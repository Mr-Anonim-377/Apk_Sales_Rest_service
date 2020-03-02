package com.Sales.SalesWeb.model.dataType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import com.Sales.SalesWeb.model.dbEnums.PgEnum;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.EnhancedUserType;
import org.hibernate.usertype.ParameterizedType;
import org.postgresql.util.PGobject;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class PgEnumUserType implements EnhancedUserType, ParameterizedType {

    public static final String ENUM_CLASS_NAME = "enumClassName";

    public static final String TYPE = "com.Sales.SalesWeb.model.dataType.PgEnumUserType";

    private Class<Enum> enumClass;

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Enum) value;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x == y;
    }

    @Override
    public Object fromXMLString(String xmlValue) {
        return getByName(xmlValue);
    }

    private Enum getByName(String value) {
        if (value == null) {
            return null;
        }
        if (PgEnum.class.isAssignableFrom(enumClass)) {
            for (Enum<?> e : enumClass.getEnumConstants()) {
                if (((PgEnum) e).getSqlValue().equalsIgnoreCase(value)) {
                    return e;
                }
            }
            throw new IllegalArgumentException("No enum constant " + enumClass.getCanonicalName() + "." + value);
        }
        return Enum.valueOf(enumClass, value);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
            throws HibernateException, SQLException {
        Object object = rs.getObject(names[0]);
        if (rs.wasNull()) {
            return null;
        }

        if (object instanceof String) {
            return getByName((String) object);
        }

        // Converts a PostGres Enum from PGobject to Java Enum
        if (object instanceof PGobject) {
            PGobject pg = (PGobject) object;
            return getByName(pg.getValue());
        }
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.VARCHAR);
        } else if (value instanceof PgEnum) {
            st.setObject(index, ((PgEnum) value).getSqlValue(), Types.OTHER);
        } else {
            // Types.OTHER (1111) gets mapped to Postgres Enum
            st.setObject(index, value, Types.OTHER);
        }
    }

    @Override
    public String objectToSQLString(Object value) {
        if (value instanceof PgEnum) {
            return '\'' + ((PgEnum) value).getSqlValue() + '\'';
        }
        return '\'' + ((Enum) value).name() + '\'';
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    @Override
    public Class returnedClass() {
        return enumClass;
    }

    @Override
    public void setParameterValues(Properties parameters) {
        String enumClassName = parameters.getProperty(ENUM_CLASS_NAME);
        try {
            enumClass = (Class<Enum>) Class.forName(enumClassName);
        } catch (ClassNotFoundException cnfe) {
            throw new HibernateException("Enum class not found", cnfe);
        }
    }
    @Override
    public int[] sqlTypes() {
        return new int[] { Types.VARCHAR };
    }

    @Override
    public String toXMLString(Object value) {
        if (value instanceof PgEnum) {
            return ((PgEnum) value).getSqlValue();
        }
        return ((Enum) value).name();
    }
}