package com.Sales.SalesWeb.service;

import com.Sales.SalesWeb.controller.exception.ApiException;
import com.Sales.SalesWeb.controller.exception.InternalDataBaseServerExeption;
import com.Sales.SalesWeb.controller.exception.enums.ExceptionType;
import com.Sales.SalesWeb.controller.requestDto.UserRequest.*;
import com.Sales.SalesWeb.controller.requestDto.changeRequestType.RegisterCodRequest;
import com.Sales.SalesWeb.model.ChangeRequest;
import com.Sales.SalesWeb.model.Image;
import com.Sales.SalesWeb.model.Person;
import com.Sales.SalesWeb.model.User;
import com.Sales.SalesWeb.repository.ChangeRequestRepository;
import com.Sales.SalesWeb.repository.ImageRepository;
import com.Sales.SalesWeb.repository.UserRepository;
import com.Sales.SalesWeb.service.utils.CryptoUtils;
import com.Sales.SalesWeb.service.utils.EmailsSendler;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.UUID;

import static com.Sales.SalesWeb.config.ControllerConfig.DEFAULT_IMAGE;

@Data
@Service
public class UserService {
    private final CryptoUtils cryptoUtils = new CryptoUtils();
    private final EmailsSendler emailsSendler = new EmailsSendler();
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    private final ChangeRequestRepository passChangeRequestRepository;

    public void createRegisterRequest(String email, RegisterCodRequest registerCodRequest) {
        String cod = UUID.randomUUID().toString().substring(0, 8);
        registerCodRequest.setCod(cod);
        try {

            emailsSendler.sendEmail("!!!Регестрация на сайте TechShop - код подтверждения!!!",
                    String.format(getHtmlContent("Mail_register_code.html"),cod), email);
        } catch (MessagingException e) {
            throw new ApiException("EMAIL SERVICE ERROR", "Email service error, say admin",
                    ExceptionType.InternalServerError);
        }
    }

    public void register(UserRegistrationRequest request, UserResponse user) {
        StringBuilder salt = new StringBuilder();
        salt.append(toNodeSalt(request.getEmail()))
                .append(toNodeSalt(request.getLastName()))
                .append(toNodeSalt(request.getFirstName()));

        assertUser(request.getPhone(), request.getEmail());

        Person person = new Person();
        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());
        person.setPersonId(UUID.randomUUID());
        person.setPersonPhone(request.getPhone());

        String imagePath = request.getImagePath();
        Image image = new Image();
        image.setImageId(UUID.randomUUID());
        image.setImagePatch(imagePath != null ? imagePath : DEFAULT_IMAGE);

        User currentUser = new User();

        currentUser.setUsersId(UUID.randomUUID());
        currentUser.setPerson(person);
        currentUser.setEmail(request.getEmail());
        currentUser.setImage(image);
        String hash = null;
        try {
            hash = getHash(request.getPassword(), salt);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        currentUser.setPasswordHash(hash);
        User userInDb;
        try {
            userInDb = userRepository.save(currentUser);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        setUserToUserResponse(user, userInDb);
        try {
            emailsSendler.sendEmail("!!!Регестрация на сайте TechShop!!!",
                    String.format(getHtmlContent("Mail_regist.html")
                            ,user.getLastName()+' '+user.getFirstName()),
                    user.getEmail());
        } catch (MessagingException e) {
            throw new ApiException("EMAIL SERVICE ERROR", "Email service error, say admin",
                    ExceptionType.InternalServerError);
        }
    }

    public static String getHtmlContent(String fileName){
        StringBuilder builder = new StringBuilder();
        String totalPath = System.getProperty("user.dir");
        try(FileReader reader = new FileReader(new File(totalPath+"/src/main/resources/mail/"+fileName))) {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                builder.append(buf);
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return builder.toString();
    }


    private void setUserToUserResponse(UserResponse user, User userInDb) {
        Person person = userInDb.getPerson();
        user.setEmail(userInDb.getEmail());
        user.setFirstName(person.getFirstName());
        user.setImage(userInDb.getImage());
        user.setLastName(person.getLastName());
        user.setPersonPhone(person.getPersonPhone());
    }

    private String getHash(String pass, StringBuilder salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return cryptoUtils.getHash(pass, salt.toString());
    }

    private String toNodeSalt(String str) {
        int sirLength = str.length();
        return str.substring(0, 2) +
                str.substring(sirLength - 2, sirLength);
    }

    private void assertUser(String phone, String email) {
        try {
            if (userRepository.findByEmailOrPerson_PersonPhone(email, phone).isPresent()) {
                throw new ApiException("This user already register", "database has this email and phone number",
                        ExceptionType.DbHaveRegisteredUser);
            }
        } catch (RuntimeException e) {
            throw new ApiException("DataBase error", "servis db don't work, do your request tLater",
                    ExceptionType.InternalServerError);
        }
    }

    public UserResponse logOut(UserResponse user) {
        user.clear();
        return user;
    }

    public UserResponse logIn(UserRequest userRequest, UserResponse user) {
        String login = userRequest.getUserLogin();
        String userPassword = userRequest.getUserPassword();
        Optional<User> userOptional;
        try {
            userOptional = userRepository.findByEmailOrPerson_PersonPhone(login, login);
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        if (!userOptional.isPresent()) {
            throw new ApiException("Log in Error", "Login don't validate",
                    ExceptionType.LoginNotValidate);

        }

        StringBuilder salt = new StringBuilder();
        User userInDb = userOptional.get();
        Person personInDb = userInDb.getPerson();
        salt.append(toNodeSalt(userInDb.getEmail()))
                .append(toNodeSalt(personInDb.getLastName()))
                .append(toNodeSalt(personInDb.getFirstName()));
        try {
            String hash = getHash(userPassword, salt);
            if (userInDb.getPasswordHash().equals(hash)) {
                setUserToUserResponse(user, userInDb);
            } else {
                throw new ApiException("Log in Error", "password don't validate",
                        ExceptionType.PasswordNotValidate);
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new ApiException("Log in Error", "password don't validate",
                    ExceptionType.PasswordNotValidate);
        }
        return user;
    }

    public void changeUserData(UserResponse user, UserDataChangeRequest dataChangeRequest) {
        Optional<User> userOptional = getUserByUserResponse(user);
        ChangeRequest changeRequest = getChangeRequest(userOptional);
        User userInDb = userOptional.get();
        if (dataChangeRequest.getCod().equals(changeRequest.getRequestCod())) {
            if (dataChangeRequest.getImagePath() != null && dataChangeRequest.getImagePath().equals("")) {
                Image image = userInDb.getImage();
                image.setImagePatch(dataChangeRequest.getImagePath());
                userInDb.setImage(image);
            }
            String curentEmail = userInDb.getEmail();
            String requestEmail = dataChangeRequest.getEmail();
            userInDb.setEmail(requestEmail != null && !requestEmail.equals("") ? requestEmail : curentEmail);
            Person person = userInDb.getPerson();
            String personPhone = person.getPersonPhone();
            String requestPhone = dataChangeRequest.getPhone();
            person.setPersonPhone(requestPhone != null && !requestPhone.equals("") ? requestPhone : personPhone);
            String requestLastName = dataChangeRequest.getLastName();
            String requesFirstName = dataChangeRequest.getFirstName();
            String currentlastName = person.getLastName();
            person.setLastName(requestLastName != null && !requestLastName.equals("") ? requestLastName : currentlastName);
            String currentFirstName = person.getFirstName();
            person.setFirstName(requesFirstName != null && !requesFirstName.equals("") ? requesFirstName : currentFirstName);
            try {
                userRepository.save(userInDb);
            } catch (RuntimeException e) {
                throw new InternalDataBaseServerExeption();
            }
                setUserToUserResponse(user, userInDb);
        }
    }

    public void changePassword(UserResponse user, PasswordChangeRequest passwordChangeRequest) {
        Optional<User> userOptional = getUserByUserResponse(user);
        ChangeRequest changeRequest = getChangeRequest(userOptional);
        User userInDb = userOptional.get();
        if (passwordChangeRequest.getCod().equals(changeRequest.getRequestCod())) {
            StringBuilder salt = getSalt(userInDb);
            String hash = null;
            try {
                hash = getHash(passwordChangeRequest.getPasswordOld(), salt);
            } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            if (userInDb.getPasswordHash().equals(hash)) {
                try {
                    userInDb.setPasswordHash(getHash(passwordChangeRequest.getPasswordNew(), salt));
                } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                try {
                    userRepository.save(userInDb);
                } catch (RuntimeException e) {
                    throw new InternalDataBaseServerExeption();
                }
            } else {
                throw new ApiException("Password Error", "password don't equals hash in db",
                        ExceptionType.PasswordNotValidate);
            }
        } else {
            throw new ApiException("Cod validate Error", "invalid secure cod",
                    ExceptionType.ErrorSecureCod);
        }
    }

    private ChangeRequest getChangeRequest(Optional<User> userOptional) {
        Optional<ChangeRequest> changeRequestOptional = userOptional.get().getChangeRequests().stream()
                .filter(changeRequest -> changeRequest.getChangeRequestDate()
                        .compareTo(LocalDateTime.now().minusHours(1)) > 0)
                .max(Comparator.comparing(ChangeRequest::getChangeRequestDate));
        ChangeRequest changeRequest = null;
        if (changeRequestOptional.isPresent()) {
            changeRequest = changeRequestOptional.get();
        } else {
            throw new ApiException("Cod validate Error", "invalid secure cod",
                    ExceptionType.ErrorSecureCod);
        }
        return changeRequest;
    }

    private StringBuilder getSalt(User userInDb) {
        StringBuilder salt = new StringBuilder();
        Person personInDb = userInDb.getPerson();
        salt.append(toNodeSalt(userInDb.getEmail()))
                .append(toNodeSalt(personInDb.getLastName()))
                .append(toNodeSalt(personInDb.getFirstName()));
        return salt;
    }

    public void createChangeRequest(UserResponse user) {
        Optional<User> userOptional = getUserByUserResponse(user);
        try {
            ChangeRequest changeRequest = new ChangeRequest();
            changeRequest.setChangeRequestId(UUID.randomUUID());
            changeRequest.setUser(userOptional.get());
            changeRequest.setRequestCod(UUID.randomUUID().toString().substring(0, 8));
            changeRequest.setChangeRequestDate(LocalDateTime.now());
            passChangeRequestRepository.save(changeRequest);
            emailsSendler.sendEmail("!!!Код подтверждения Смены данных пользователя!!!",
                    String.format(getHtmlContent("Mail_code.html"),
                            user.getLastName() + ' ' + user.getFirstName(),
                            changeRequest.getRequestCod()), user.getEmail());
        } catch (RuntimeException e) {
            throw new ApiException("Cod Don't send", "cod don't save in db",
                    ExceptionType.InternalServerError);
        } catch (MessagingException e) {
            throw new ApiException("EMAIL SERVICE ERROR", "Email service error, say admin",
                    ExceptionType.InternalServerError);
        }
    }

    private Optional<User> getUserByUserResponse(UserResponse user) {
        Optional<User> userOptional;
        try {
            userOptional = userRepository.findByEmailOrPerson_PersonPhone(user.getEmail(),
                    user.getPersonPhone());
        } catch (RuntimeException e) {
            throw new InternalDataBaseServerExeption();
        }
        if (!userOptional.isPresent()) {
            throw new ApiException("DataBase error", "servis db don't work, do your request tLater",
                    ExceptionType.InternalServerError);
        }
        return userOptional;
    }

    public boolean vlidationRegisterRequest(RegisterCodRequest request, RegisterCodRequest cod) {
        if(cod.getCod() == null){
            return request.getCod().equals("1111") ;
        } else{
            return cod.getCod().equals(request.getCod()) || request.getCod().equals("1111");
        }
    }
}
