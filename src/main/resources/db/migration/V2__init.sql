CREATE TABLE IF NOT EXISTS product (
id SERIAL PRIMARY KEY,
description VARCHAR(255) NOT NULL,
brand VARCHAR(255) NOT NULL,
price DECIMAL(10, 2),
stock INT
);

CREATE TABLE IF NOT EXISTS datail (
id SERIAL,
quantity INT NOT NULL,
price DECIMAL(10, 2),
invoice_id INT,
product_id INT,
FOREIGN KEY (invoice_id ) REFERENCES invoice(id),
FOREIGN KEY (product_id ) REFERENCES product(id)
);