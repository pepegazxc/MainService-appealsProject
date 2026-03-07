CREATE TABLE cities(
    id BIGSERIAL PRIMARY KEY,
    city_name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO cities (city_name) VALUES ('Moscow'), ('Belgrade'), ('Warsaw');

CREATE TABLE appeals_status(
    id BIGSERIAL PRIMARY KEY,
    status_name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO appeals_status(status_name) VALUES ('NEW'), ('RESOLVED'), ('IN_PROGRESS'),('REJECTED');

ALTER TABLE appeals ADD COLUMN
created_at TIMESTAMPTZ NOT NULL DEFAULT now();
ALTER TABLE appeals ADD COLUMN
city_id BIGINT NOT NULL;
ALTER TABLE appeals ADD COLUMN
status_id BIGINT NOT NULL;
ALTER TABLE appeals ADD COLUMN
resolved_at TIMESTAMPTZ DEFAULT NULL;




ALTER TABLE appeals ADD CONSTRAINT fk_city
FOREIGN KEY (city_id) REFERENCES cities(id);

ALTER TABLE appeals ADD CONSTRAINT fk_status
FOREIGN KEY (status_id) REFERENCES appeals_status(id);
