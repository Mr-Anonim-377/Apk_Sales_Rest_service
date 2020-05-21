INSERT INTO public.images (image_id, image_patch)
VALUES ('c6371c0a-1541-42c2-b460-5b30f8d4c8fc', 'https://slide-share.ru/mainImage/5071827.jpeg');
INSERT INTO public.images (image_id, image_patch)
VALUES ('ea3ab0c5-8186-444c-947c-36cb8904cacd',
        'https://modelist-konstruktor.com/images/arch/1344-modernizirovannye-grabli/0.jpg');
INSERT INTO public.images (image_id, image_patch)
VALUES ('0e7277ae-9a06-4e51-a41e-e767bb2c95bf', 'https://bookprose.ru/pictures/1014426255.jpg');
INSERT INTO public.images (image_id, image_patch)
VALUES ('6bba85f7-ab17-46a9-8049-bdcf073452ba',
        'https://mh-don.ru/images/stories/virtuemart/product/e13667e64bca85316337ffa8921ffa39.jpg');
INSERT INTO public.images (image_id, image_patch)
VALUES ('153dc2d0-4a1c-4b17-bd97-da4de0e57092',
        'https://im0-tub-ru.yandex.net/i?id=cb7663d001058405f3c03853841496bc&n=13');
INSERT INTO public.images (image_id, image_patch)
VALUES ('e8324613-3a15-406f-afe1-3e8e93b416cf',
        'https://static-eu.insales.ru/images/products/1/7483/232004923/a792c744339e03139b8f5256cddd14dd.jpeg');
INSERT INTO public.images (image_id, image_patch)
VALUES ('efece03b-ea50-4cca-943a-8c29023d6f58',
        'https://avatars.mds.yandex.net/get-pdb/27625/1c04e15a-aae8-462c-b63f-1e20f7aaeb79/s1200');
INSERT INTO public.images (image_id, image_patch)
VALUES ('f8034544-91df-4588-a51c-0c26c157b2e6',
        'https://img2.freepng.ru/20180403/jgq/kisspng-watering-cans-computer-icons-clip-art-cans-5ac42fad9053f4.7008729115228067015912.jpg');
INSERT INTO public.images (image_id, image_patch)
VALUES ('5e41c8cd-9c4d-4af2-8298-e0a29c2519cf',
        'https://img2.freepng.ru/20180303/ggw/kisspng-garden-shovel-tool-usability-vector-hand-painted-shovels-5a9a67b9ca02a9.9856530715200685378274.jpg');
INSERT INTO public.images (image_id, image_patch)
VALUES ('501e4e67-6f67-4478-ad3c-e5b752679130',
        'https://img2.freepng.ru/20180605/reu/kisspng-straw-hat-photography-headgear-straw-5b172daed2e408.5740780315282456788638.jpg');
INSERT INTO public.images (image_id, image_patch)
VALUES ('c048234a-ba22-49c9-93c8-efe77da541ed',
        'https://img2.freepng.ru/20180712/kxu/kisspng-lentil-snow-pea-legume-vegetable-pod-blue-pea-5b46df2f991a21.1718466015313713116271.jpg');
INSERT INTO public.images (image_id, image_patch)
VALUES ('e9ee5032-e87a-4ab8-bdba-2ee521b0f349',
        'https://c7.hotpng.com/preview/193/1023/594/corn-on-the-cob-sweet-corn-clip-art-corn.jpg');
INSERT INTO public.categories (category_id, parent_category_id, category_name)
VALUES (1, null, '10.02');
INSERT INTO public.categories (category_id, parent_category_id, category_name)
VALUES (2, null, '10.0rtretert');
ALTER SEQUENCE categories_category_id_seq RESTART WITH 3;
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (2, 'ertrtre', 'ertertert', 'c6371c0a-1541-42c2-b460-5b30f8d4c8fc');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (3, '4545', '454545', 'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (4, 'boro', 'boro', '0e7277ae-9a06-4e51-a41e-e767bb2c95bf');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (5, 'lopata', 'lopata', '6bba85f7-ab17-46a9-8049-bdcf073452ba');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (6, 'shlang', 'shlang', '153dc2d0-4a1c-4b17-bd97-da4de0e57092');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (7, 'rez', 'rez', 'e8324613-3a15-406f-afe1-3e8e93b416cf');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (8, 'chto', 'chtoto', 'efece03b-ea50-4cca-943a-8c29023d6f58');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (9, 'leyka', 'leyka', 'f8034544-91df-4588-a51c-0c26c157b2e6');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (10, 'kross', 'cross', '5e41c8cd-9c4d-4af2-8298-e0a29c2519cf');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (11, 'hat', 'hat', '501e4e67-6f67-4478-ad3c-e5b752679130');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (12, 'peas', 'peas', 'c048234a-ba22-49c9-93c8-efe77da541ed');
INSERT INTO public.collections (collection_id, collection_name, collection_description, image_id)
VALUES (13, 'corn', 'corn', 'e9ee5032-e87a-4ab8-bdba-2ee521b0f349');
ALTER SEQUENCE collections_collection_id_seq RESTART WITH 14;
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('03e57dd0-bc6b-41ac-859e-bbb5674b1e12', 'hat', 1, 100.00, '501e4e67-6f67-4478-ad3c-e5b752679130', 11,
        '{"i":"23"}', 'bla bla bla');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('52c49df5-2461-421c-b7b8-b7621e9a6b4a', 'peas', 1, 200.00, 'c048234a-ba22-49c9-93c8-efe77da541ed', 12,
        '{"i":"23"}', 'bla bla bla');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('eab59874-e8c6-4122-8c11-099401def297', 'corn', 2, 300.00, 'e9ee5032-e87a-4ab8-bdba-2ee521b0f349', 13,
        '{"i":"23"}', 'bla bla bla');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('1aeddfd8-fe73-463a-8670-32884596e61b', 'ertrtre', 1, 123.00, 'c6371c0a-1541-42c2-b460-5b30f8d4c8fc', 2,
        '{"i":"23"}', 'tttt');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('6f1a625b-0fc7-458b-9afb-1f5c573f57c2', '4545', 1, 1345.00, 'ea3ab0c5-8186-444c-947c-36cb8904cacd', 3,
        '{"i":"23"}', 'tttt');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('55224f94-e12b-406a-901b-e12f8e3328d7', 'lopata', 2, 27.56, '6bba85f7-ab17-46a9-8049-bdcf073452ba', 5,
        '{"i":"23"}', 'tttt');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('42b3b8ac-7ff5-4802-beb3-63eddd44b5f1', 'shlang', 1, 1500.00, '153dc2d0-4a1c-4b17-bd97-da4de0e57092', 6,
        '{"i":"23"}', 'bla bla');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('93aae1dc-a3e3-4c8f-89ba-6d604642eb1f', 'kross', 2, 2100.00, '5e41c8cd-9c4d-4af2-8298-e0a29c2519cf', 10,
        '{"i":"23"}', 'bla bla');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('33ca8fd0-5fc7-484f-be43-9eac73a98be9', 'boro', 2, 100.00, '0e7277ae-9a06-4e51-a41e-e767bb2c95bf', 4,
        '{"i":"23"}', 'tttt');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('b316e5e3-52e4-4b43-94b9-3e0c92818fcc', 'rez', 1, 1600.00, 'e8324613-3a15-406f-afe1-3e8e93b416cf', 7,
        '{"i":"23"}', 'bla bla');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties,
                             product_description)
VALUES ('8097e4cb-bd40-4401-8ff3-29f6cb0b0e57', 'chtoto', 2, 3600.00, 'efece03b-ea50-4cca-943a-8c29023d6f58', 8,
        '{"i":"23"}', 'bla bla');
INSERT INTO public.products (product_id, name_product, category_id, price, image_id, collection_id, properties, product_description) VALUES ('c8e77279-2775-45e8-ba5a-5e212cf01340', 'leyka', 2, 2000.00, 'f8034544-91df-4588-a51c-0c26c157b2e6', 9, '["Гарантия: 45 лет","Происзводство: СССР"]', 'Косметика и парфюмерия Dolcegabbana Dolce Gabbana
                Light Blue Туалетная вода Dolce Gabbana Light Blue - чувственный и искрящийся аромат,
                который символизирует юность и наслаждение жизни, подчеркивая индивидуальность и очарование
                своей обладательницы. Свежее звучание композиции на основе переплетения цветочных и
                фруктовых букетов - это одно из достоинств парфюма, которое дает возможность погрузиться в
                упоительное ощущение прохлады лазурных просторов.');
INSERT INTO public.favorite_category (favorite_category_id, category_id, popular_value)
VALUES ('c6371c0a-1541-42c2-b460-5b30f8d4c8fc', 1, 1);
INSERT INTO public.favorite_category (favorite_category_id, category_id, popular_value)
VALUES ('ea3ab0c5-8186-444c-947c-36cb8904cacd', 2, 2);
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('ed3b13d3-a786-4ce0-8b70-b2e2129cc316', '1aeddfd8-fe73-463a-8670-32884596e61b',
        'c6371c0a-1541-42c2-b460-5b30f8d4c8fc');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('168f2adc-0c67-44bd-b804-6906f8e9196f', '6f1a625b-0fc7-458b-9afb-1f5c573f57c2',
        'c6371c0a-1541-42c2-b460-5b30f8d4c8fc');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('ee559964-b465-4637-8ba9-768fe0401e76', '55224f94-e12b-406a-901b-e12f8e3328d7',
        'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('3fbf98fa-f2dc-45e7-b7dd-4163697b35df', '33ca8fd0-5fc7-484f-be43-9eac73a98be9',
        'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('653557a5-89ea-4901-aa55-a0669bc7f69f', '03e57dd0-bc6b-41ac-859e-bbb5674b1e12',
        'c6371c0a-1541-42c2-b460-5b30f8d4c8fc');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('6de59a78-50bd-46a0-b49c-8b736cadf41f', 'b316e5e3-52e4-4b43-94b9-3e0c92818fcc',
        'c6371c0a-1541-42c2-b460-5b30f8d4c8fc');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('e21e1d42-c1ba-4563-bc0b-f48efe89276f', '52c49df5-2461-421c-b7b8-b7621e9a6b4a',
        'c6371c0a-1541-42c2-b460-5b30f8d4c8fc');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('4ea79f36-57f3-4b68-907e-2087420fb15d', '42b3b8ac-7ff5-4802-beb3-63eddd44b5f1',
        'c6371c0a-1541-42c2-b460-5b30f8d4c8fc');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('49495465-734f-4fd7-8525-62e70d19117d', '8097e4cb-bd40-4401-8ff3-29f6cb0b0e57',
        'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('58fa6801-24ff-4ea8-8fd9-ba736fdd116d', '93aae1dc-a3e3-4c8f-89ba-6d604642eb1f',
        'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('87dca7f1-6ae4-4ac5-aa5f-30540157563e', 'eab59874-e8c6-4122-8c11-099401def297',
        'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO public.favorite_category_products (favorite_category_product_id, product_id, favorite_category_id)
VALUES ('4b49dab2-ea4f-4f0b-88f4-76c8234601f0', 'c8e77279-2775-45e8-ba5a-5e212cf01340',
        'ea3ab0c5-8186-444c-947c-36cb8904cacd');
INSERT INTO public.persons (person_id, person_phone, first_name, last_name)
VALUES ('6f1a625b-0fc7-458b-9afb-1f5c573f57c2', '73355534534', 'test', 'test');
INSERT INTO public.users (users_id, person_id, email, image_id, password_hash)
VALUES ('6f1a625b-0fc7-458b-9afb-1f5c573f57c2', '6f1a625b-0fc7-458b-9afb-1f5c573f57c2', 'w.zzzz@mail.ru',
        'c6371c0a-1541-42c2-b460-5b30f8d4c8fc', '-29D5FA8B2152F0D0A793FAFA8CBB5457');