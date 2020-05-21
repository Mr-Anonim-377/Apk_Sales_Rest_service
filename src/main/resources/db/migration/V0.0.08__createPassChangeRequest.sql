create TABLE "change_request"
(
        "change_request_id" uuid DEFAULT gen_random_uuid() NOT NULL,
    "user_id"   uuid                           NOT NULL,
    "request_cod" text                           NOT NULL,
    "change_request_date" TIMESTAMP             NOT NULL,
    CONSTRAINT "pass_change_request_pkey" PRIMARY KEY ("change_request_id")
);
ALTER TABLE "change_request"
    ADD CONSTRAINT "fk_pass_change_request_user" FOREIGN KEY ("user_id") REFERENCES "users" ("users_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
