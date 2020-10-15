
UPDATE categories SET category_name = 'Садовая техника' where category_id = '1';
UPDATE categories SET category_name = 'Садовый инвентарь' where category_id = '2';
INSERT INTO categories VALUES ('3', null, 'Товары для полива');
INSERT INTO categories VALUES ('4', null, 'Товары для уборки снега');
INSERT INTO categories VALUES ('5', null, 'Уход за растениями');
INSERT INTO categories VALUES ('6', null, 'Почвообрабатывающая и посевная техника');
INSERT INTO categories VALUES ('7', null, 'Тракторы и транспортные средства');
INSERT INTO categories VALUES ('8', null, 'Уборочная техника');
INSERT INTO categories VALUES ('9', null, 'Оборудование для обработки и хранения урожая');
INSERT INTO categories VALUES ('10', null, 'Техника для химической защиты и полива');
INSERT INTO categories VALUES ('11', '1', 'Культиваторы и мотоблоки');
INSERT INTO categories VALUES ('12', '1', 'Цепные пилы');
INSERT INTO categories VALUES ('13', '1', 'Садовые измельчители');
INSERT INTO categories VALUES ('14', '2', 'Лопаты');
INSERT INTO categories VALUES ('15', '2', 'Грабли');
INSERT INTO categories VALUES ('16', '2', 'Тяпки, мотыги и плоскорезы');
INSERT INTO categories VALUES ('17', '3', 'Шланги для полива');
INSERT INTO categories VALUES ('18', '3', 'Пистолеты для полива');
INSERT INTO categories VALUES ('19', '3', 'Системы автоматического полива');
INSERT INTO categories VALUES ('20', '4', 'Снегоуборочные машины');
INSERT INTO categories VALUES ('21', '4', 'Лопаты для уборки снега');
INSERT INTO categories VALUES ('22', '4', 'Ледорубы');
INSERT INTO categories VALUES ('23', '5', 'Грунты для растений');
INSERT INTO categories VALUES ('24', '5', 'Удобрения для растений');
INSERT INTO categories VALUES ('25', '5', 'Горшки и кашпо для цветов');
INSERT INTO categories VALUES ('26', '6', 'Бороны и катки');
INSERT INTO categories VALUES ('27', '6', 'Картофелесажалки');
INSERT INTO categories VALUES ('28', '6', 'Культиваторы');
INSERT INTO categories VALUES ('29', '7', 'Тракторы');
INSERT INTO categories VALUES ('30', '7', 'Устройства электронного контроля');
INSERT INTO categories VALUES ('31', '7', 'Автомобильная техника');
INSERT INTO categories VALUES ('32', '8', 'Оборудование для уборки овощей');
INSERT INTO categories VALUES ('33', '8', 'Косилки');
INSERT INTO categories VALUES ('34', '8', 'Комбайны');
INSERT INTO categories VALUES ('35', '9', 'Машины для обработки и хранения овощей ');
INSERT INTO categories VALUES ('36', '9', 'Оборудование для обработки и хранения зерна');
INSERT INTO categories VALUES ('37', '9', 'Транспортеры');
INSERT INTO categories VALUES ('38', '10', 'Оборудование контроля состояния почвы ');
INSERT INTO categories VALUES ('39', '10', 'Оборудование поливочное');
INSERT INTO categories VALUES ('40', '10', 'Опрыскиватели');
INSERT INTO categories VALUES ('41', '26', 'Катки дисковые ');
INSERT INTO categories VALUES ('42', '26', 'Катки игольчатые');
INSERT INTO categories VALUES ('43', '26', 'Бороны зубовые');
INSERT INTO categories VALUES ('44', '29', 'Гусеничные тракторы ');
INSERT INTO categories VALUES ('45', '29', 'Колёсные тракторы');
INSERT INTO categories VALUES ('46', '33', 'Косилки дисковые ');
INSERT INTO categories VALUES ('47', '33', 'Косилки садовые');
INSERT INTO categories VALUES ('48', '33', 'Косилки-измельчители');
INSERT INTO categories VALUES ('49', '34', 'Комбайны кормоуборочные');
INSERT INTO categories VALUES ('50', '34', 'Комбайны зерноуборочные');
INSERT INTO categories VALUES ('51', '36', 'Зерносушилки');
INSERT INTO categories VALUES ('52', '36', 'Оборудование для очистки зерна');
INSERT INTO categories VALUES ('53', '36', 'Оборудование для получения масла');
INSERT INTO categories VALUES ('54', '39', 'Машины автономные');
INSERT INTO categories VALUES ('55', '39', 'Машины подачи воды');
INSERT INTO categories VALUES ('56', '40', 'Опрыскиватели ручные');
INSERT INTO categories VALUES ('57', '40', 'Опрыскиватели штанговые');

INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('00ac291e-086f-43f9-a8c5-1b75d9a5efff', 'Мотоблок Carver МТ-700 7 л/с', 11, 25741.00, '537ab81d-f6f7-413c-9c63-aa2a05d3e468', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Мотоблок Carver МТ-700 оснащен новой 2х-ступенчатой коробкой передач, которая позволяет наиболее оптимально использовать мотоблок для выполнения разнообразных агротехнических работ. Мотоблок Carver MT-700 относится к изделиям малогабаритной сельскохозяйственной техники и предназначен для выполнения широкого круга сельскохозяйственных работ на индивидуальных садовых и приусадебных участках, в фермерских и садово-парковых хозяйствах. Мотоблок с прицепными и навесными орудиями используется для выполнения пахоты, культивации, рыхления, междурядной обработки почвы, кошения травы', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('acfc85cf-0c72-42dc-92ab-18a1c38356c4', 'Мотоблок Мобил К МКМ-3 ЛМ 6.5 л/с', 11, 37952.00, '0f1d13be-a3ae-454a-bddd-4ecaf7166221', null, '["Гарантия - 10 лет","Производство - Россия"]', ' Мотоблок Мобил К МКМ-3 – мотоблок №1 по легкости в работе среди мотоблоков Мобил К. Предыдущая модель- МКМ-3 Lander-Пахарь был 100% хитом за все 10 лет, которые он производился. В 2018 году мы выпустили новое поколение этого мотоблока! Мобил К МКМ-3 это мотоблок нового поколения с самой высокой планкой технологичности и образец инновационного подхода в проектировании и машиностроении.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('3ed26088-4b66-4f66-aff6-c695b76d56bf', 'Мотокультиватор Sterwins Model 1. 3,5 л/с', 11, 18301.00, '2f6f7150-f68e-459b-89ae-a9dca4371535', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Мотокультиватор Sterwins Model 1 — садовая, сельскохозяйственная машина для подготовки почвы к высаживанию растений. Оснащается рулевой колонкой, бензиновым четырехтактным агрегатом Dinking, колесами. Трансмиссия — цепная. Используется мототехника для обработки почвы — вспахивания, рыхления, окучивания. Запускается вручную с использованием троса. От мотоблоков отличается меньшими весом, мощностью, функциональностью.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('936bda73-97f2-4947-8cfa-b621cb0d0f89', 'Мотокультиватор бензиновый Sterwins-2. 6,5 л/с', 11, 28711.00, '6abaf0b1-3194-4284-ab2f-61fc9b7ba526', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Мотокультиватор Sterwins-2 — это оборудование, которое существенно упрощает и ускоряет проведение сельскохозяйственных работ. Удобен и прост в эксплуатации. Мощный культиватор, работающий на бензине, способен обработать внушительную площадь земли.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('40275378-6729-4ebb-a12a-e7972245bb5f', 'Культиватор электрический «Земляк» КЭ-1300 Вт', 11, 5877.00, 'afc516e9-dd6c-4e88-8c3d-ff1bdf3ed0d8', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Электрокультиватор «Земляк» КЭ-1300 оснащён мощным электрическим двигателем 1300 Вт и предназначен для рыхления и вспахивания почвы. Агрегат обладает более тихим уровнем шума, по сравнению с бензиновыми аналогами, а так же полностью отсутствуют выхлопные газы.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('3cf230dd-e826-4818-bf44-1b7bff1d277e', 'Мотоблок Pubert Transformer 60P TWK. 6 л/с', 11, 47216.00, 'b1e2793c-9901-4967-9847-339b7894d983', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Мотоблок Pubert Transformer является продолжением линейки Vario и отвечает самым высоким требованиям по качеству, надежности и уровню технологических инновационных решений. Мотоблок Pubert Transformer 60P TWK+ для целинных земель по фунциональности не уступающий мотоблокам профессионального класса, с внушительной шириной захвата 90 см. Его мощность и вес позволяют обрабатывать тяжелые участки почвы.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('32b0456c-e598-46e0-82d2-b2dc90259af0', 'Грунт для цветов универсальный 20 л', 23, 5422.00, '3e9a9f9f-bb67-4c42-afd7-49c89cb3a2b6', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Грунты для садовых растений. Грунт Универсальный', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('a31cb4ff-39c3-4b6d-b3de-30118b94b98f', 'Грунт Geolia Premium «Универсальный» 50 л', 23, 5422.00, '1fd1c75d-f8cd-4ac3-85ce-e0aebb2a8231', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Грунты для садовых растений. Грунт Универсальный', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('0db823c9-92db-462f-8c45-6c876e25a818', 'Мотокультиватор бензиновый Патриот Ока. 4 л/с', 11, 17534.00, 'd8a7d254-0d87-4d90-81ad-023ebc43b185', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Культиватор бензиновый Patriot Ока по цене , профессиональное качество для дома и сада! Техника и инструменты Patriot от производителя.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('6d51098a-46a7-4ca5-8779-9bc713619cb2', 'Мотокультиватор бензиновый Патриот «Ростов» 7 л/с', 11, 20634.00, '28f93468-10db-436f-99be-4a643aabb0f2', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Культиватор бензиновый Patriot Ростов по цене , профессиональное качество для дома и сада! Техника и инструменты Patriot от производителя. ', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('263249cb-b4f1-4199-8ecf-7e2542a1f8e6', 'Мотокультиватор бензиновый «Земляк-45» 5 л/с', 11, 14991.00, '9a097d00-876d-4150-bc53-11a031386f8f', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Мотокультиватор «Земляк-45» используется в домашних хозяйствах для рыхления почвы. Он отлично подойдет для обработки небольших участков, где земля вспахивается каждый год. Купить его у нас можно за небольшую для такой техники цену.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('9ce566c8-b34b-4d35-ba23-c1d4290ab549', 'Мотоблок бензиновый Патриот «Владимир-2» РФ. 7 л/с', 11, 29992.00, '7194fd28-689d-4da1-8bc3-73545492974c', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Мотоблок бензиновый Патриот «Владимир-2» (РФ) — универсальная бытовая машина, напоминающая мини-трактор. Состоит из ручек управления, колес и силового агрегата. Мощность техники 5,22 кВт, ширина захвата — 90 см. Мотоблок можно использовать для работы на небольшом дачном участке и в поле.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('7603bd70-6b98-42da-a0b2-ec172260da1e', 'Пила бензиновая цепная Makita EA3202S40B, 1350 Вт шина 40 см', 12, 10440.00, 'f0866092-5bf4-4556-b37e-c0f7bf451f5b', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Цепная пила Makita EA 3202S 40B станет надежным помощником в любом фермерском хозяйстве. С ее помощью можно заготавливать дрова на зиму, валить небольшие деревья', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('50d220b4-51a4-414a-aeda-7a6e3334a0b0', 'Пила электрическая цепная Bosch AKE 40S шина 40 см', 12, 7991.00, 'b16a76bb-96ab-4418-a996-bc71e746fba7', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Рассчитываю, что цепная пила Bosch AKE 40 S должна великолепно подойти для нерегулярного использования на моем садовом участке. Пила поможет во многих работах для обеспечения комфорта при загородном проживании и решения бытовых задач. ', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('b0dd6d83-6f48-4212-87a6-69c85c19195c', 'Пила электрическая YT4334, 1800 Вт шина 35 см', 12, 3293.00, '79829bfe-eec5-43e3-baab-c3b4364d37c7', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Электрическая цепная пила CMI 1800 Вт имеет легкую компактную конструкцию, необходимые в работе защитные функции, удобную систему', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('d84849e7-2936-4aa6-86be-edb74df2d678', 'Пила злектрическая цепная Bosch AKE 35 1800 Вт, шина 35 см', 12, 6698.00, '2cfbdb70-a08b-48c2-9221-a78db1ceb2f1', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Длина шины составляет оптимальные 35 см, благодаря чему инструмент имеет хорошую маневренность. Преимущества. - Мощность двигателя 1800 Вт, что дает повышенный КПД при более низком уровне шума и вибрации по сравнению с бензиновыми аналогами.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('204c8510-573f-456f-a8ec-34dca9e7a27a', 'Пила бензиновая цепная Калибр БП-1800/16У шина 40 см', 12, 4232.00, 'b0b315a3-94be-4c5f-b02c-8210141d5d4f', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Технические характеристики бензиновой пилы БП-1800 16У. Инструкция по эксплуатации, особенности обслуживания. Достоинства и недостатки цепной бензопилы Калибр БП-1800 16У. Видео-обзор Калибра модели БП-1800 16У. ', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('92ec30ef-e80a-493a-9856-bfeb8995fa5a', 'Пила цепная электрическая «Парма» М6 1000 Вт шина 30 см', 12, 4081.00, 'a8a843a8-a4aa-4870-b37f-1e451c23a63d', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Электрическая цепная пила Парма М4. Смотровое окошко масляного бака позволяет своевременно заполнять емкость, не доводя до полного опустошения. Используется шина 40 см длиной и цепь на 57 звеньев', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('331d1c9c-47f3-4e3d-9533-c40916587125', 'Пила цепная электрическая Makita UC3541A 1800 Вт шина 35 см', 12, 7491.00, '7bb9a116-83db-41d5-874a-748cff18eaa1', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Электрическая цепная пила Makita UC3541A - легкий инструмент для распиливания древесины. Модель оснащена щеточным электроприводом мощностью 1800 Вт. Это позволяет использовать пилу в закрытом помещении.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('112a4508-2026-4b04-b564-520fe961695c', 'Лопата совковая 130 см с черенком', 14, 161.00, '7d85cef0-d6b7-4994-b674-a8e853291545', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Лопата совковая с деревянным черенком, 280х230х1500мм, предназначена для перемещения песка, гравия и других сыпучих материалов. Деревянный отшлифованный черенок оптимальной длины', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('e7398eae-3942-4bac-a386-fa4359997d41', 'Лопата штыковая Fiskars Solid 116 см', 14, 801.00, '064fe70b-8cad-4a8c-a2ad-d45196b1bd1c', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Лопата штыковая Fiskars Solid используется при работе с грунтом — для вскапывания и разрыхления земли. Удобство работы обеспечивает эргономичная рукоятка. Рабочая часть инструмента остроконечная, изготовлена из стали.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('87477170-9244-4987-85af-2b46529166f8', 'Грунт «Агрикола» универсальный 50 л', 23, 5422.00, '05dc9b83-78a6-40be-b34e-a05e370925ac', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Грунты для садовых растений. Грунт Универсальный', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('517d4aa7-6fcb-4bdd-a4b7-1e3f3b5e27b3', 'Лопата штыковая остроугольная 130 см с черенком', 14, 155.00, '0f1d13be-a3ae-454a-bddd-4ecaf7166221', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Штыковая лопата для работ в саду и на приусадебном участке. Прочная, крепкая и надежная в работе. Длина лопаты с черенком составляет 130 см, ширина стальной рабочей части - 22 см.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('61a5fb76-35d9-4365-87eb-58fb07843ba2', 'Грабли веерные проволочные усиленные с черенком', 15, 131.00, '0f0853c1-cc6a-4071-8f71-20db44f2af07', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Грабли веерные Gandy Модерн проволочные оцинкованные с черенком, 22 зубца', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('5eae1cf1-efcb-435d-939e-01cb5b04bb81', 'Грабли регулируемые 125 см сталь', 15, 150.00, '60188587-73b2-4b9d-99db-fc9503522d54', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Грабли регулируемые из стали используются во время садовых работ. Купить их можно для уборки листвы с дорожек .', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('99604557-ca4d-4534-ba1e-c95f6a2ddf43', 'Грабли витые 12 зубьев с черенком', 15, 200.00, '0f1d13be-a3ae-454a-bddd-4ecaf7166221', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Предназначаются для сбора листвы, скошенной травы, мусора и разрыхления перекопанной земли.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('bcfd42b9-3db9-47ad-b947-fd9464cfe86a', 'Мотыга М-190 138 см сталь', 16, 145.00, 'f3f27a4c-841e-4dc6-89fd-635131a0f7f7', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Мотыга М-190 – удобный инструмент, изготовленный из надежных материалов. Он предназначается для обработки почвы в саду, огороде, в теплицах, а также будет очень полезен при уборке снега. Деревянный черенок удобно лежит в ладони, а рабочая часть, изготовле.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('1dd7be81-28ce-445b-82e3-c4316bb0b1a8', ' Косилка (КРН-2,1)', 46, 47952.00, '9f43357c-8fec-4456-9b40-f0b61dbe4745', null, '["Гарантия - 10 лет","Производство - Россия"]', ' Предназначена для скашивания высокоурожайных и полеглых трав на повышенных поступательных скоростях с укладкой скошенной массы в прокос. Машина применяется во всех зонах страны. ', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('9731a987-6e70-42a8-91c0-eda2c9290e53', ' Косилка (КТН-4)', 46, 30952.00, '466b2643-c172-4e25-af3b-eb2d22766210', null, '["Гарантия - 10 лет","Производство - Россия"]', ' Предназначена для скашивания трав на повышенных поступательных скоростях, агрегатируется с тракторами класса 0,9-1,4 т.с. Навеска правосторонняя с нижним приводом.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('04d72585-f803-4b7b-9852-c2ffd406fd9c', 'Косилка (КТН-4)', 46, 63000.00, 'e522e4eb-2c87-4dbb-a2df-ee3bbb7a68a3', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Косилка (КТН-4) - фото, описание с ценами, технические характеристики, производители и поставщики в каталоге сельхозтехники', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('3d6ea662-c973-4421-8b96-3d788b558530', 'Газонокосилка электрическая Gardena PowerMax 1100/32, 1100 Вт, 32 см', 47, 10000.00, 'e0aaeaa3-bd69-4e65-8024-c398e4b3035d', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Газонокосилка электрическая Gardena PowerMax 1100/32. Легкая и компактная электрическая газонокосилка Gardena PowerMax 1100/32 отлично подходит для работы на небольших участках и на любом типе газона.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('3ee9774a-f8fa-488c-be6c-2caa84a5d011', 'Газонокосилка электрическая YT5139, 1000 Вт, 32 см', 47, 5952.00, '2cc80746-11b4-4dfb-b4fc-37138b04de33', null, '["Гарантия - 10 лет","Производство - Россия"]', ' Газонокосилка электрическая ― необходимая садовая техника, которая помогает поддерживать газон и территорию приусадебного участка в порядке', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('31e5a289-3a8d-4337-ae0d-35d9d20c0d69', 'Газонокосилка электрическая AL-KO Classic 3.8, 1400 Вт, 38 см', 47, 3952.00, '4a153860-e6cc-4ad2-9b08-3c1f747031c7', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Достаточно компактная и лёгкая газонокосилка с 1300-Вт электродвигателем на борту. Ширина покоса составляет 38 см, система выброса скошенной травы – в специальный 43-литровый мешок, система мульчирования не предусмотрена. Реализована классическая возможность регулировки высоты среза, но при этом она ручного типа и предусматривает только 4 установки в пределах от 23 до 62 мм. ', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('d7535afc-b230-4154-93d6-ef729190b167', 'Аппарат для дробления соломы (Foton)', 48, 27952.00, 'edc1c462-5b57-431f-b0dc-5ac145591d50', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Предназначен для измельчения пожнивных остатков. Технические характеристики. Foton. 1JHY-135. 1JHY-150.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('adb4fb70-5b52-4fad-8947-340ed12596ee', 'Дождеватель для полива осциллирующий Gardena Polo Classic Canadian, 220 (м²)', 55, 7000.00, '8786b217-35b9-4bcf-a252-03164e10b162', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Дождеватель осциллирующий GARDENA Polo 220 Classic обеспечивает оптимальный полив Вашего газона. Наличие турбомеханизма обеспечивает равномерный полив участка площадью от 90 до 220 м2. Дальность полива регулируется в диапазоне 7-17 м, ширина зоны полива при этом составляет не более 13 метров. Наличие мелкоячеистого фильтра из высококачественной нержавеющей стали устраняет необходимость проводить работы по техническому обслуживанию дождевателя. ', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('1509320e-0b8d-453c-a7a2-6322eb5b8157', 'Грунт Geolia «Универсальный» 50 л', 23, 5422.00, 'b65e455a-32c6-438e-b701-d18b11c8add2', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Грунты для садовых растений. Грунт Универсальный', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('0b050fb3-6637-4fb7-82f2-f3a4eac5dd4d', 'Торф верховой нейтрализованный 150 л', 23, 5422.00, '7fdc3610-53d6-4d29-b507-a85f94a8846c', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Грунты для садовых растений. Грунт Универсальный', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('d92b2c57-e7a7-4b27-a85b-7f51cb4569b0', 'Дождеватель для полива осциллирующий Gardena Aquazoom 250 (м²)', 55, 7952.00, '0e3e5bd4-d513-454d-ae6d-f05ca7f13dfb', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Дождеватель Aquazoom 250/2 Comfort GARDENA идеально подходит для полива небольших прямоугольных участков площадью от 25 до 250 м2. Дальность полива плавно регулируется в диапазоне 7-18 м. Ширина зоны полива выбирается в пределах 3,5-14 м. Для оптимального полива высоких растений дождеватель можно установить на штатив GARDENA. Дождеватель Aquazoom 250/2 Comfort GARDENA обеспечит безупречный полив Вашего газона.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('ca88c240-9f4f-4aab-a7b9-b54909b58677', 'Дождеватель для полива осциллирующий Gardena ZoomMaxx 216 (м²)', 55, 8052.00, '71406119-d91c-45e2-bd4f-505940f0d179', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Дождеватель осциллирующий Gardena ZoomMaxx предназначен для капельного полива растений. Механизм обеспечивает равномерное орошение участка. Специальное основание позволяет безопасно установить устройство даже на наклонной поверхности.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('5c45689f-557e-4b9a-92e4-1c2da9fe2dab', 'Дождеватель для полива осциллирующий Geolia, 190 (м²)', 55, 10952.00, '7bbf5178-45d8-42e8-8e10-89f6aa177ee6', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Дождеватель Geolia представляет собой осциллирующий разбрызгиватель для орошения участков прямоугольной формы. В состав входит пластиковая подставка и дугообразная металлическая трубка с выпуклыми соплами. При равномерном поливе разбрызгивающая трубка колеблется: максимальная дальность струек достигает 8 м. Дождеватель подключается к водопроводу с использованием шланга.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('7e3959c5-9276-45a6-a94f-a39f5e8a0351', 'Дождеватель для полива импульсный Geolia, 500 (м²)', 55, 3002.00, 'd4e3e232-d811-4530-ad48-0ae15a9ec56d', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Импульсный дождеватель на платформе от итальянского производителя поливочных систем GF произведёт импульсный полив в виде дождя овощных культур, цветников, лужаек и газонов над стволами и листьями без риска их повреждения. Дождеватель на платформе легко перемещается и чиститься создаёт объёмную дождевую массу, образованную из мельчайших водяных капелек. ', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('7ee8b94b-9eda-4a91-af24-6a3bf0a0e581', 'Дождеватель для полива круговой Gardena «Mambo» 310', 55, 3252.00, '255ad3d6-d05c-4389-806b-081b28034a24', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Дождеватель круговой GARDENA Mambo Comfort предназначен для комфортного полива как небольших, так и крупных участков. Площадь полива составляет 9-310 м2, а диаметр полива регулируется в диапазоне от 3 до 20 м. Вращающиеся высокоточные наконечники дождевателя обеспечивают равномерный полив без образования луж.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('156383c4-2a03-4d4a-a6b6-3caec11e1f4f', 'Дождеватель для полива циркулярный Geolia, 100 (м²), 8 режимов.', 55, 38052.00, '60682fc5-8bbb-42e1-a091-9504c7890ea7', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Дождеватель Geolia — компактный разбрызгиватель воды, орошающий до 100 м^2^ сада, огорода или газона. Изготовлен из ABS-пластика, оснащен оригинальной системой с 8 отверстиями и соединительным штуцером под шланг диаметром 15 мм. Режимы переключаются поворотом крышки вокруг собственной оси с фиксацией на каждой позиции.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('7d1f1224-4840-43fb-9b5b-133b7f36a32d', 'Дождеватель для полива импульсный Boutte, 530 (м²)', 55, 13052.00, '4b735900-a1d8-47b2-b713-38172397b6a2', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Импульсный круговой дождеватель Boutte обеспечивает равномерный полив на площади до 615 кв.м. Он представляет собой прочную конструкцию, выполненную из высококачественного металла.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('2aa651d5-edd5-4d9c-8c20-b32629bafc5c', 'Ледоруб-топор 160 мм', 22, 422.00, 'f5edc644-a939-4a66-82f1-26d76bbdaaa6', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Изготовлен из стали. Представляет собой топор с металлическим черенком. Предназначен для скалывания льда.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('79f2dc64-69df-487d-98fe-b06bbf8cc956', ' Лом «Ледокол Lux»', 22, 622.00, '91193cd0-9cbd-4b99-9ad4-88a436d475dc', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Лом ледокол LUX — это инструмент для раскалывания льда и уборки плотного, слежавшегося снега. Черенок изготовлен из стали, сверху покрыт полиэтиленовой трубкой, что снижает степень скольжения при работе с изделием.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('7a32ab6e-6e4e-4d99-a1fa-866f517f1c82', 'Ледоруб-скребок с черенком 20x120 см металл', 22, 5422.00, 'f6760d30-e36e-42b4-bac6-59da52bf5424', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Ледоруб-скребок Сибртех металлический черенок. Ширина рабочей части: 20 см Металлический черенок Длина черенка: 120 ', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('b23fdcd2-8bfb-4e11-bc00-0f9fc36f36c3', 'Грунт универсальный 150 л', 23, 5422.00, '5ec3cf86-4f1a-46c4-b906-c355c7266746', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Грунты для садовых растений. Грунт Универсальный', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('3b4bac35-4a44-4bdf-9712-5f978b0a90af', 'Грунт универсальный «Просто» 50 л', 23, 5422.00, '469a7adf-47da-46c2-b0c6-e9f7d332ed9a', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Грунты для садовых растений. Грунт Универсальный Просто 50 Л', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('22a6d3ae-c8dc-4a55-a2b8-ae303710bb32', 'Ветроводоподъемник (ВВ-5Т) ', 54, 200022.00, '003be241-6580-4c34-8609-a9bbbb8872ea', null, '["Гарантия - 10 лет","Производство - Россия"]', ' Предназначен для водоснабжения пастбищ, фермерских хозяйств и других объектов из трубчатых и шахтных колодцев за счет использования энергии ветра в регионах со среднегодовой скоростью ветра свыше 3 м/с.', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('b5a0c4e5-4009-4b2f-b896-3c51b911fe3e', 'Ветронасосная установка (ВНУ-1)', 54, 150422.00, 'c794c06b-8dab-46f0-bbc6-b98c331d4f3d', null, '["Гарантия - 10 лет","Производство - Россия"]', 'Ветронасосная установка модели ВНУ-1 предназначена для механизации подъема воды поршневым глубинным насосом из трубчатых колодцев глубиной до 20 м в районах, где среднегодовые скорости ветра составляют 5-8 м/с. Использование глубинного насоса в данной установке значительно упрощает процесс эксплуатации, позволяя использовать ее в автономном режиме. ', null, null);
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description, average_mark, sum_mark) VALUES ('3f0ff7b1-2e5c-4429-a30f-c1e5f9d068ea', 'Станция ветроэлектрическая мобильная автономная (Фрегат) ', 54, 35022.00, '91204af9-e500-4977-99b9-6b870b26201f', null, '["Гарантия - 10 лет","Производство - Россия"]', ' Предназначена для преобразования энергии ветра в электрическую. Ветроэлектрические станции типа М-А-ВЭС-ВТ, мощностью от 8 до 16 кВт, могут использоваться в любых климатических зонах Российской Федерации, стран СНГ и дальнего зарубежья, где отсутствует или возможно временное отключение постоянного электроснабжения.', null, null);


INSERT INTO public.images (image_id, image_patch) VALUES ('c6371c0a-1541-42c2-b460-5b30f8d4c8fc', 'https://slide-share.ru/mainImage/5071827.jpeg');
INSERT INTO public.images (image_id, image_patch) VALUES ('ea3ab0c5-8186-444c-947c-36cb8904cacd', 'https://modelist-konstruktor.com/images/arch/1344-modernizirovannye-grabli/0.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('0e7277ae-9a06-4e51-a41e-e767bb2c95bf', 'https://bookprose.ru/pictures/1014426255.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('6bba85f7-ab17-46a9-8049-bdcf073452ba', 'https://mh-don.ru/images/stories/virtuemart/product/e13667e64bca85316337ffa8921ffa39.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('153dc2d0-4a1c-4b17-bd97-da4de0e57092', 'https://im0-tub-ru.yandex.net/i?id=cb7663d001058405f3c03853841496bc&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('e8324613-3a15-406f-afe1-3e8e93b416cf', 'https://static-eu.insales.ru/images/products/1/7483/232004923/a792c744339e03139b8f5256cddd14dd.jpeg');
INSERT INTO public.images (image_id, image_patch) VALUES ('efece03b-ea50-4cca-943a-8c29023d6f58', 'https://avatars.mds.yandex.net/get-pdb/27625/1c04e15a-aae8-462c-b63f-1e20f7aaeb79/s1200');
INSERT INTO public.images (image_id, image_patch) VALUES ('f8034544-91df-4588-a51c-0c26c157b2e6', 'https://img2.freepng.ru/20180403/jgq/kisspng-watering-cans-computer-icons-clip-art-cans-5ac42fad9053f4.7008729115228067015912.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('5e41c8cd-9c4d-4af2-8298-e0a29c2519cf', 'https://img2.freepng.ru/20180303/ggw/kisspng-garden-shovel-tool-usability-vector-hand-painted-shovels-5a9a67b9ca02a9.9856530715200685378274.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('501e4e67-6f67-4478-ad3c-e5b752679130', 'https://img2.freepng.ru/20180605/reu/kisspng-straw-hat-photography-headgear-straw-5b172daed2e408.5740780315282456788638.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('c048234a-ba22-49c9-93c8-efe77da541ed', 'https://img2.freepng.ru/20180712/kxu/kisspng-lentil-snow-pea-legume-vegetable-pod-blue-pea-5b46df2f991a21.1718466015313713116271.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('e9ee5032-e87a-4ab8-bdba-2ee521b0f349', 'https://c7.hotpng.com/preview/193/1023/594/corn-on-the-cob-sweet-corn-clip-art-corn.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('68a74708-add5-488b-a0f3-29eb4c005c31', 'http://img0.joyreactor.cc/pics/post/ПеКа-кавайная-няка-42804.png');
INSERT INTO public.images (image_id, image_patch) VALUES ('4e229ad1-f620-4ad5-a2d3-e74ad4759bec', 'http://img0.joyreactor.cc/pics/post/ПеКа-кавайная-няка-42804.png');
INSERT INTO public.images (image_id, image_patch) VALUES ('537ab81d-f6f7-413c-9c63-aa2a05d3e468', 'https://s.leroymerlin.ru/upload/catalog/img/e/5/82169280/800x800/82169280_01.jpg?v=1471');
INSERT INTO public.images (image_id, image_patch) VALUES ('0f1d13be-a3ae-454a-bddd-4ecaf7166221', 'https://irkutsk.kit-home.ru/image/product/leroy/f5/a0/f5a015bd15494e49f6566f7519feb70788d38fcf.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('2f6f7150-f68e-459b-89ae-a9dca4371535', 'https://s.leroymerlin.ru/upload/catalog/img/c/8/81955990/800x800/81955990.jpg?v=1466');
INSERT INTO public.images (image_id, image_patch) VALUES ('6abaf0b1-3194-4284-ab2f-61fc9b7ba526', 'https://fhcdnarticles-a.akamaihd.net/1605610/thumb_585.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('afc516e9-dd6c-4e88-8c3d-ff1bdf3ed0d8', 'https://im0-tub-ru.yandex.net/i?id=fb34bb7fb28d7277c5f8f34fa7946ca1&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('b1e2793c-9901-4967-9847-339b7894d983', 'https://im0-tub-ru.yandex.net/i?id=fb34bb7fb28d7277c5f8f34fa7946ca1&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('d8a7d254-0d87-4d90-81ad-023ebc43b185', 'https://avtovelomoto.by/upload/iblock/7fc/460_10_4598_1.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('28f93468-10db-436f-99be-4a643aabb0f2', 'https://syzran.mozmarket.ru/images/detailed/47/b514823b-9f6f-11e7-b272-08002723f43a_7a0fb5b6-180a-11ea-ab40-00505690cb17.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('9a097d00-876d-4150-bc53-11a031386f8f', 'https://res.cloudinary.com/lmru/image/upload/f_auto,q_auto,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/13570475.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('7194fd28-689d-4da1-8bc3-73545492974c', 'https://res.cloudinary.com/lmru/image/upload/f_auto,q_auto,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/82169237_05.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('f0866092-5bf4-4556-b37e-c0f7bf451f5b', 'https://megatool.com.ua/image/cache/catalog/products/sadovaya-tehnika/benzopila-cepnaya-makita-ea-3203-s40b-1200x630.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('b16a76bb-96ab-4418-a996-bc71e746fba7', 'https://im0-tub-ru.yandex.net/i?id=48989b9a2ecdd6d7f3ad0df07cb6a306&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('79829bfe-eec5-43e3-baab-c3b4364d37c7', 'https://katalogcen.ru/media/lots/2019-08/1564686691_yt4334.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('2cfbdb70-a08b-48c2-9221-a78db1ceb2f1', 'https://msk.wadoo.ru/upload/iblock/9c8/9c8a9a2742749ead079774edec46970e.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('b0b315a3-94be-4c5f-b02c-8210141d5d4f', 'https://i.rubanok.co/diygoods/26858/pila_benzinovaya_tsepnaya_kalibr_bp_180016u_shina_40_sm_1_foto.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('a8a843a8-a4aa-4870-b37f-1e451c23a63d', 'https://im0-tub-ru.yandex.net/i?id=e098369a8da7b86277543634cef8ffe1&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('7bb9a116-83db-41d5-874a-748cff18eaa1', 'https://drelmarket.ru/images/detailed/9/makita-uc3541a_2.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('7d85cef0-d6b7-4994-b674-a8e853291545', 'https://res.cloudinary.com/lmru/image/upload/f_auto,q_auto,w_1200,h_1200,c_pad,b_white,d_photoiscoming.png/LMCode/14363689.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('064fe70b-8cad-4a8c-a2ad-d45196b1bd1c', 'https://im0-tub-ru.yandex.net/i?id=070a25f18a2af4e746f70357276094c1&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('96ef605a-173f-4362-9f2e-daac2d421e04', 'https://user43214.clients-cdnnow.ru/image/cache/catalog/211/211015_7b323-1000x1000.png');
INSERT INTO public.images (image_id, image_patch) VALUES ('0f0853c1-cc6a-4071-8f71-20db44f2af07', 'https://static.bestru.ru/massload/718962/6a71395a971005b6545bfa96056acbe3.jpeg');
INSERT INTO public.images (image_id, image_patch) VALUES ('60188587-73b2-4b9d-99db-fc9503522d54', 'https://s.leroymerlin.ru/upload/catalog/img/9/e/14262861/800x800/14262861.jpg?v=1471');
INSERT INTO public.images (image_id, image_patch) VALUES ('2404744d-0c8b-4bfe-89e4-8e0fabf49e61', 'https://aatrade.ru/image/cache/catalog/i/am/hb/0088e85b32a61325bd31473a8f34ce07-1200x630.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('f3f27a4c-841e-4dc6-89fd-635131a0f7f7', 'https://im0-tub-ru.yandex.net/i?id=38584ce500710f329c109ff30a014d96&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('9f43357c-8fec-4456-9b40-f0b61dbe4745', 'http://img.agrobase.ru/agro/images/Machinery/3c113349-fc81-4666-85fa-da2005db0e0d.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('466b2643-c172-4e25-af3b-eb2d22766210', 'https://agrotrade-td.ru/wp-content/uploads/2019/10/Kosilka-KRN-21-4.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('e522e4eb-2c87-4dbb-a2df-ee3bbb7a68a3', 'https://agrotrade-td.ru/wp-content/uploads/2019/10/Kosilka-KRN-21-4.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('e0aaeaa3-bd69-4e65-8024-c398e4b3035d', 'https://im0-tub-ru.yandex.net/i?id=3b09873f0a7cea12564793b6a2ee8d48&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('2cc80746-11b4-4dfb-b4fc-37138b04de33', 'https://sun9-19.userapi.com/c206724/v206724262/c8b88/ELPkDsBkZjc.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('4a153860-e6cc-4ad2-9b08-3c1f747031c7', 'https://im0-tub-ru.yandex.net/i?id=da6568f7f1cc8ad3135ea04ffd0493bc&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('edc1c462-5b57-431f-b0dc-5ac145591d50', 'http://img.agrobase.ru/agro/images/Machinery/1dcebd86-b9a0-424b-9a52-ad822a6779ac.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('8786b217-35b9-4bcf-a252-03164e10b162', 'https://st43.stblizko.ru/images/product/326/917/145_large.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('0e3e5bd4-d513-454d-ae6d-f05ca7f13dfb', 'https://cdn1.ozone.ru/s3/multimedia-a/6009807526.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('71406119-d91c-45e2-bd4f-505940f0d179', 'https://im0-tub-ru.yandex.net/i?id=e6a004e1fa1a2c8d7d91a2f98d570553&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('7bbf5178-45d8-42e8-8e10-89f6aa177ee6', 'https://s.leroymerlin.ru/upload/catalog/img/e/e/82502458/362x362/82502458.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('d4e3e232-d811-4530-ad48-0ae15a9ec56d', 'https://im0-tub-ru.yandex.net/i?id=e7937fe1930ddf1bc687b27e03377ec2&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('255ad3d6-d05c-4389-806b-081b28034a24', 'https://www.gardenstock.ru/up/imgs/products/10372/10372_b.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('60682fc5-8bbb-42e1-a091-9504c7890ea7', 'https://s.leroymerlin.ru/upload/catalog/img/1/9/81965686/800x800/81965686.jpg?v=1462');
INSERT INTO public.images (image_id, image_patch) VALUES ('4b735900-a1d8-47b2-b713-38172397b6a2', 'http://avtopoliv-primesad.ru/image/cache/catalog/Ruchnoi-poliv/Dojdevateli/Boutte/0804078/dozhdevatel-impulsnyj-krugovoj-na-kolyshke-boutte-2-800x800.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('f5edc644-a939-4a66-82f1-26d76bbdaaa6', 'https://im0-tub-ru.yandex.net/i?id=a534c2bcae58b2f3d2f78cd34bf127d7&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('91193cd0-9cbd-4b99-9ad4-88a436d475dc', 'http://vss63.ru/-imager/?m=1&src=~catalog/ВолгаСпецСнаб/images/Инструмент/Лом-ЛЕДОКОЛ-ледоруб.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('f6760d30-e36e-42b4-bac6-59da52bf5424', 'https://im0-tub-ru.yandex.net/i?id=0a2322977d368bbda376b4591473d93d&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('b65e455a-32c6-438e-b701-d18b11c8add2', '');
INSERT INTO public.images (image_id, image_patch) VALUES ('3e9a9f9f-bb67-4c42-afd7-49c89cb3a2b6', 'https://im0-tub-ru.yandex.net/i?id=790e4e0ddbabacc887457e6b920063f6&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('1fd1c75d-f8cd-4ac3-85ce-e0aebb2a8231', 'https://s.leroymerlin.ru/upload/catalog/img/7/6/18611133/800x800/18611133.jpg?v=1462');
INSERT INTO public.images (image_id, image_patch) VALUES ('05dc9b83-78a6-40be-b34e-a05e370925ac', 'https://irecommend.ru/sites/default/files/product-images/174229/fEpGlOL7ZhaqcXIpg0GFg.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('7fdc3610-53d6-4d29-b507-a85f94a8846c', 'https://s.leroymerlin.ru/upload/catalog/img/4/b/82016383/800x800/82016383_tmp.jpg?v=1471');
INSERT INTO public.images (image_id, image_patch) VALUES ('5ec3cf86-4f1a-46c4-b906-c355c7266746', 'https://im0-tub-ru.yandex.net/i?id=5369d05732767e10e06a4eb3cb03d9e7&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('469a7adf-47da-46c2-b0c6-e9f7d332ed9a', 'https://im0-tub-ru.yandex.net/i?id=d2e6425d4bad1a5ff8ef54dc5e22f799&n=13');
INSERT INTO public.images (image_id, image_patch) VALUES ('003be241-6580-4c34-8609-a9bbbb8872ea', 'http://img.agrobase.ru/agro/images/Machinery/633101761818750000.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('c794c06b-8dab-46f0-bbc6-b98c331d4f3d', 'http://img.agrobase.ru/agro/images/Machinery/c50a1be0-5a17-4ce1-8de5-8358226b3a68.jpg');
INSERT INTO public.images (image_id, image_patch) VALUES ('91204af9-e500-4977-99b9-6b870b26201f', 'http://img.agrobase.ru/agro/images/Machinery/633072416747968750.jpg');
INSERT INTO public.favorite_category (favorite_category_id, category_id, popular_value)
VALUES ('c6371c0a-1541-42c2-b460-5b30f8d4c8fc', 1, 1);
INSERT INTO public.favorite_category (favorite_category_id, category_id, popular_value)
VALUES ('ea3ab0c5-8186-444c-947c-36cb8904cacd', 2, 2);
INSERT INTO favorite_category VALUES ('83fddae8-f503-41f7-8a52-4f3046f78489', '33', '3');
INSERT INTO favorite_category VALUES ('eb366f25-3b42-4a3b-be89-982b34e773f6', '55', '4');
INSERT INTO favorite_category VALUES ('81a41685-5c67-494a-8cab-b7aebf66b126', '22', '5');
INSERT INTO favorite_category VALUES ('753041bb-cdce-41f9-82a0-18066f79901a', '23', '6');
INSERT INTO favorite_category VALUES ('d6e1478d-3781-45be-bae7-d05d27242b53', '39', '7');
INSERT INTO favorite_category_products VALUES ('2fe07275-f41f-4c80-81d6-62db3aba1449', '22a6d3ae-c8dc-4a55-a2b8-ae303710bb32', 'd6e1478d-3781-45be-bae7-d05d27242b53');
INSERT INTO favorite_category_products VALUES ('b1e05f95-5375-46f1-b939-67d4b9966e60', 'b5a0c4e5-4009-4b2f-b896-3c51b911fe3e', 'd6e1478d-3781-45be-bae7-d05d27242b53');
INSERT INTO favorite_category_products VALUES ('90cdc5a0-0c27-4e97-9366-57f77df0146d', '3f0ff7b1-2e5c-4429-a30f-c1e5f9d068ea', 'd6e1478d-3781-45be-bae7-d05d27242b53');
INSERT INTO favorite_category_products VALUES ('f2903a6b-1fcb-4a1a-980c-140d9561b9bd', '7e3959c5-9276-45a6-a94f-a39f5e8a0351', 'd6e1478d-3781-45be-bae7-d05d27242b53');
INSERT INTO favorite_category_products VALUES ('380540ec-cdcb-41ef-a981-6bf63087343f', '156383c4-2a03-4d4a-a6b6-3caec11e1f4f', 'd6e1478d-3781-45be-bae7-d05d27242b53');
INSERT INTO favorite_category_products VALUES ('6501c763-97ca-49f2-8a2f-c62854a85209', '32b0456c-e598-46e0-82d2-b2dc90259af0', '753041bb-cdce-41f9-82a0-18066f79901a');
INSERT INTO favorite_category_products VALUES ('735cb2b5-9045-46ad-b347-28a42a475e73', 'a31cb4ff-39c3-4b6d-b3de-30118b94b98f', '753041bb-cdce-41f9-82a0-18066f79901a');
INSERT INTO favorite_category_products VALUES ('e8546fb2-7688-46f2-857a-bb9cb5261ebe', '87477170-9244-4987-85af-2b46529166f8', '753041bb-cdce-41f9-82a0-18066f79901a');
INSERT INTO favorite_category_products VALUES ('808619ea-ac90-44a7-a0fa-70ac142e84f1', '1509320e-0b8d-453c-a7a2-6322eb5b8157', '753041bb-cdce-41f9-82a0-18066f79901a');
INSERT INTO favorite_category_products VALUES ('ad0dcc61-3422-40fe-9392-bda04ae56bdd', '0b050fb3-6637-4fb7-82f2-f3a4eac5dd4d', '753041bb-cdce-41f9-82a0-18066f79901a');
INSERT INTO favorite_category_products VALUES ('1198a359-91e5-4c27-9ec5-4afc16946e5b', 'b23fdcd2-8bfb-4e11-bc00-0f9fc36f36c3', '753041bb-cdce-41f9-82a0-18066f79901a');
INSERT INTO favorite_category_products VALUES ('a7986f1b-3f5c-4854-8821-38139eea871a', '3b4bac35-4a44-4bdf-9712-5f978b0a90af', '753041bb-cdce-41f9-82a0-18066f79901a');
INSERT INTO favorite_category_products VALUES ('090758a0-7daf-491e-8886-dbad42fa16ac', '2aa651d5-edd5-4d9c-8c20-b32629bafc5c', '81a41685-5c67-494a-8cab-b7aebf66b126');
INSERT INTO favorite_category_products VALUES ('b0e83fb6-d149-4c27-9390-8aac821a4471', '79f2dc64-69df-487d-98fe-b06bbf8cc956', '81a41685-5c67-494a-8cab-b7aebf66b126');
INSERT INTO favorite_category_products VALUES ('fe3b5c19-fd39-4d5b-883f-550e9b89eb0b', '7a32ab6e-6e4e-4d99-a1fa-866f517f1c82', '81a41685-5c67-494a-8cab-b7aebf66b126');
INSERT INTO favorite_category_products VALUES ('0798f7de-098c-41bf-85f3-d4ad438f6b79', 'adb4fb70-5b52-4fad-8947-340ed12596ee', 'eb366f25-3b42-4a3b-be89-982b34e773f6');
INSERT INTO favorite_category_products VALUES ('9ecb9fda-10fe-4429-a878-7f091bbb35f3', 'd92b2c57-e7a7-4b27-a85b-7f51cb4569b0', 'eb366f25-3b42-4a3b-be89-982b34e773f6');
INSERT INTO favorite_category_products VALUES ('721bfecc-ac7d-47ad-8da2-999f84c7b1cf', 'ca88c240-9f4f-4aab-a7b9-b54909b58677', 'eb366f25-3b42-4a3b-be89-982b34e773f6');
INSERT INTO favorite_category_products VALUES ('1193af5e-480c-407c-8cce-42957c105238', '5c45689f-557e-4b9a-92e4-1c2da9fe2dab', 'eb366f25-3b42-4a3b-be89-982b34e773f6');
INSERT INTO favorite_category_products VALUES ('fde31a79-a225-4ea8-bb90-e06e56f3ff55', '7e3959c5-9276-45a6-a94f-a39f5e8a0351', 'eb366f25-3b42-4a3b-be89-982b34e773f6');
INSERT INTO favorite_category_products VALUES ('4ac3f541-7439-476c-9e2d-f45e60d25e2b', '7ee8b94b-9eda-4a91-af24-6a3bf0a0e581', 'eb366f25-3b42-4a3b-be89-982b34e773f6');
INSERT INTO favorite_category_products VALUES ('95406dec-7803-4ec8-8e8e-77de51b6275b', '156383c4-2a03-4d4a-a6b6-3caec11e1f4f', 'eb366f25-3b42-4a3b-be89-982b34e773f6');
INSERT INTO favorite_category_products VALUES ('36007969-12eb-4253-af0b-9f744646df9d', '7d1f1224-4840-43fb-9b5b-133b7f36a32d', 'eb366f25-3b42-4a3b-be89-982b34e773f6');
INSERT INTO favorite_category_products VALUES ('1189d7c4-97a7-4cd0-a86b-a27f922164de', 'bcfd42b9-3db9-47ad-b947-fd9464cfe86a', 'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO favorite_category_products VALUES ('0bdb81ed-4f66-4ad1-9e38-432c5279317b', '99604557-ca4d-4534-ba1e-c95f6a2ddf43', 'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO favorite_category_products VALUES ('87b5b09c-7665-4b60-9c07-372484cda1ce', '5eae1cf1-efcb-435d-939e-01cb5b04bb81', 'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO favorite_category_products VALUES ('234a55d2-3043-457a-91b3-9c9a0b9b9fcb', '61a5fb76-35d9-4365-87eb-58fb07843ba2', 'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO favorite_category_products VALUES ('d1ca4c67-a9cb-4e49-8e35-bb81d1e490d6', '517d4aa7-6fcb-4bdd-a4b7-1e3f3b5e27b3', 'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO favorite_category_products VALUES ('25d6bbba-1fca-446d-ad00-f6b3c5070bdd', 'e7398eae-3942-4bac-a386-fa4359997d41', 'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO favorite_category_products VALUES ('dcf3450c-e5db-4862-a5bc-48a713bcfea9', '112a4508-2026-4b04-b564-520fe961695c', 'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO favorite_category_products VALUES ('b04d924d-61a2-42c9-b117-2418a49482e2', 'd7535afc-b230-4154-93d6-ef729190b167', '83fddae8-f503-41f7-8a52-4f3046f78489');
INSERT INTO favorite_category_products VALUES ('3298b7cc-1c81-431f-811c-bb22cce13662', '31e5a289-3a8d-4337-ae0d-35d9d20c0d69', '83fddae8-f503-41f7-8a52-4f3046f78489');
INSERT INTO favorite_category_products VALUES ('8d84c8cf-ec71-4448-bb99-f6a86041ecc7', '3ee9774a-f8fa-488c-be6c-2caa84a5d011', '83fddae8-f503-41f7-8a52-4f3046f78489');
INSERT INTO favorite_category_products VALUES ('8aa33c56-d58e-4b96-8d28-3c43807ecfa6', '3d6ea662-c973-4421-8b96-3d788b558530', '83fddae8-f503-41f7-8a52-4f3046f78489');
INSERT INTO favorite_category_products VALUES ('3764283c-11dc-4bb3-8c53-d25b6309378d', '04d72585-f803-4b7b-9852-c2ffd406fd9c', '83fddae8-f503-41f7-8a52-4f3046f78489');
INSERT INTO favorite_category_products VALUES ('4cde5f7a-0d05-4da4-8014-5c04c16ab5e1', '9731a987-6e70-42a8-91c0-eda2c9290e53', '83fddae8-f503-41f7-8a52-4f3046f78489');
INSERT INTO favorite_category_products VALUES ('cefd17f1-bfc7-4a9b-9bf3-ba99dba0ef18', '1dd7be81-28ce-445b-82e3-c4316bb0b1a8', '83fddae8-f503-41f7-8a52-4f3046f78489');

INSERT INTO images values ('089c2f4c-123e-46ff-9576-9200c28dda1c', 'https://fruitree.ru/wp-content/uploads/2019/11/70221_big.jpg ');

INSERT INTO collections VALUES ('1', 'Уход за садом', 'Уход за садом', '089c2f4c-123e-46ff-9576-9200c28dda1c');

INSERT INTO images values ('cca66be2-1985-4c44-81a9-80c6b8172d3c', 'https://landshaftm.ru/assets/images/resources/129/primer-uxod-za-sadom-5-min.jpg');

INSERT INTO collections VALUES ('2', 'Электротовары', 'Электротовары', 'cca66be2-1985-4c44-81a9-80c6b8172d3c');

INSERT INTO images values ('8124ef3b-eb68-4c7f-86c3-8dcf2ee26d61', 'https://st0.isolux.ru/media/wysiwyg/gazon-strijka.jpg');

INSERT INTO collections VALUES ('3', 'Уход за газоном', 'Уход за газоном', '8124ef3b-eb68-4c7f-86c3-8dcf2ee26d61');

INSERT INTO images values ('a927ac24-8b6e-4373-9488-240bfd1f3d6f', 'https://avatars.mds.yandex.net/get-pdb/1985244/91dead7c-b631-4a29-bfa1-2eb0d0f97e9f/s1200');

INSERT INTO collections VALUES ('4', 'Комнатные растения','Комнатные растения', 'a927ac24-8b6e-4373-9488-240bfd1f3d6f');

INSERT INTO images values ('2257c059-3d1c-492c-9236-041eee5c0dbe', 'https://avatars.mds.yandex.net/get-zen_doc/964926/pub_5c85283a9b1ab400b58b91b0_5c8529a6f117cb00b38c3a0b/scale_1200');

INSERT INTO collections VALUES ('5', 'Полив растений', 'Полив растений', '2257c059-3d1c-492c-9236-041eee5c0dbe');

UPDATE products set collection_id = '1' where product_id = '112a4508-2026-4b04-b564-520fe961695c';

UPDATE products set collection_id = '1' where product_id = 'e7398eae-3942-4bac-a386-fa4359997d41';

UPDATE products set collection_id = '1' where product_id = '517d4aa7-6fcb-4bdd-a4b7-1e3f3b5e27b3';

UPDATE products set collection_id = '1' where product_id = '61a5fb76-35d9-4365-87eb-58fb07843ba2';

UPDATE products set collection_id = '1' where product_id = '5eae1cf1-efcb-435d-939e-01cb5b04bb81';

UPDATE products set collection_id = '1' where product_id = '99604557-ca4d-4534-ba1e-c95f6a2ddf43';

UPDATE products set collection_id = '2' where product_id = '50d220b4-51a4-414a-aeda-7a6e3334a0b0';

UPDATE products set collection_id = '2' where product_id = 'b0dd6d83-6f48-4212-87a6-69c85c19195c';

UPDATE products set collection_id = '2' where product_id = 'd84849e7-2936-4aa6-86be-edb74df2d678';

UPDATE products set collection_id = '2' where product_id = '92ec30ef-e80a-493a-9856-bfeb8995fa5a';

UPDATE products set collection_id = '2' where product_id = '331d1c9c-47f3-4e3d-9533-c40916587125';

UPDATE products set collection_id = '3' where product_id = '3d6ea662-c973-4421-8b96-3d788b558530';

UPDATE products set collection_id = '3' where product_id = '3ee9774a-f8fa-488c-be6c-2caa84a5d011';

UPDATE products set collection_id = '3' where product_id = '31e5a289-3a8d-4337-ae0d-35d9d20c0d69';

UPDATE products set collection_id = '3' where product_id = '40275378-6729-4ebb-a12a-e7972245bb5f';

UPDATE products set collection_id = '4' where product_id = '3b4bac35-4a44-4bdf-9712-5f978b0a90af';

UPDATE products set collection_id = '4' where product_id = 'b23fdcd2-8bfb-4e11-bc00-0f9fc36f36c3';

UPDATE products set collection_id = '4' where product_id = '0b050fb3-6637-4fb7-82f2-f3a4eac5dd4d';

UPDATE products set collection_id = '4' where product_id = '1509320e-0b8d-453c-a7a2-6322eb5b8157';

UPDATE products set collection_id = '4' where product_id = '87477170-9244-4987-85af-2b46529166f8';

UPDATE products set collection_id = '4' where product_id = '32b0456c-e598-46e0-82d2-b2dc90259af0';

UPDATE products set collection_id = '4' where product_id = 'a31cb4ff-39c3-4b6d-b3de-30118b94b98f';

UPDATE products set collection_id = '5' where product_id = '7ee8b94b-9eda-4a91-af24-6a3bf0a0e581';

UPDATE products set collection_id = '5' where product_id = '7e3959c5-9276-45a6-a94f-a39f5e8a0351';

UPDATE products set collection_id = '5' where product_id = '5c45689f-557e-4b9a-92e4-1c2da9fe2dab';

UPDATE products set collection_id = '5' where product_id = 'ca88c240-9f4f-4aab-a7b9-b54909b58677';

UPDATE products set collection_id = '5' where product_id = 'd92b2c57-e7a7-4b27-a85b-7f51cb4569b0';

UPDATE products set collection_id = '5' where product_id = 'adb4fb70-5b52-4fad-8947-340ed12596ee';

UPDATE products set collection_id = '5' where product_id = '22a6d3ae-c8dc-4a55-a2b8-ae303710bb32';

UPDATE products set collection_id = '5' where product_id = '156383c4-2a03-4d4a-a6b6-3caec11e1f4f';

UPDATE products set collection_id = '5' where product_id = '7d1f1224-4840-43fb-9b5b-133b7f36a32d';