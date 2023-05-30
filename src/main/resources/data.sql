DROP TABLE IF EXISTS DETAILS_ORDER_PRODUCT;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS DETAILS_ORDER;
CREATE TABLE PRODUCT (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description VARCHAR(255) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE DETAILS_ORDER (
                               id SERIAL PRIMARY KEY,
                               order_id BIGINT NOT NULL,
                               client_id BIGINT NOT NULL,
                               quantity INT NOT NULL,
                               price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE DETAILS_ORDER_PRODUCT (
                                       detail_order_id BIGINT REFERENCES DETAILS_ORDER (id),
                                       product_id BIGINT REFERENCES PRODUCT (id),
                                       PRIMARY KEY (detail_order_id, product_id)
);

ALTER TABLE PRODUCT ADD COLUMN category VARCHAR(255) NOT NULL DEFAULT '';
ALTER TABLE PRODUCT ADD COLUMN car BOOLEAN;

SELECT id, COUNT(*) FROM PRODUCT GROUP BY id HAVING COUNT(*) > 1;

INSERT INTO PRODUCT (name, category, description, price, car)
VALUES
    ('Producto 1', 'HAMBURGUESA', 'Descripción 1', 9.99, false),
    ('Producto 2', 'HAMBURGUESA', 'Descripción 2', 12.99, false),
    ('Producto 3', 'HAMBURGUESA', 'Descripción 3', 7.99, false),
    ('Producto 4', 'HAMBURGUESA', 'Descripción 4', 14.99, false),
    ('Producto 5', 'PERRO CALIENTE', 'Descripción 5', 11.99, false),
    ('Producto 6', 'PERRO CALIENTE', 'Descripción 6', 8.99, false),
    ('Producto 7', 'PERRO CALIENTE', 'Descripción 7', 10.99, false),
    ('Producto 8', 'OTROS', 'Descripción 8', 6.99, false),
    ('Producto 9', 'OTROS', 'Descripción 9', 13.99, false),
    ('Producto 10', 'OTROS', 'Descripción 10', 9.49, false);
