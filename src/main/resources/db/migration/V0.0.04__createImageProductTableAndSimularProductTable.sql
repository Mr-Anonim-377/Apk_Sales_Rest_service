
create TABLE "images_product"
(
    "images_product" uuid DEFAULT gen_random_uuid() NOT NULL,
    "image_id"   uuid                           NOT NULL,
    "product_id" uuid                           NOT NULL,
    CONSTRAINT "images_product_pkey" PRIMARY KEY ("image_id")
);
create TABLE "similar_product"
(
    "similar_product_id" uuid DEFAULT gen_random_uuid() NOT NULL,
    "product_id"   uuid                           NOT NULL,
    "similars_product_id" uuid                           NOT NULL,
    CONSTRAINT "similar_product_pkey" PRIMARY KEY ("similar_product_id")
);
ALTER TABLE "images_product"
    ADD CONSTRAINT "fk_images_product_images" FOREIGN KEY ("image_id") REFERENCES "images" ("image_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "images_product"
    ADD CONSTRAINT "fk_images_product_product" FOREIGN KEY ("product_id") REFERENCES "products" ("product_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "similar_product"
    ADD CONSTRAINT "fk_similar_product_product_id" FOREIGN KEY ("product_id") REFERENCES "products" ("product_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "similar_product"
    ADD CONSTRAINT "fk_similar_product_similar_product_id" FOREIGN KEY ("similars_product_id") REFERENCES "products" ("product_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
