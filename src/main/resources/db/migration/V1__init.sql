CREATE TABLE IF NOT EXISTS client (
    id SERIAL PRIMARY KEY,
    nui CHAR(10) UNIQUE NOT NULL,
    fullname VARCHAR(100) NOT NULL,
    adress VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS invoice (
    id SERIAL PRIMARY KEY,
    code VARCHAR(30) UNIQUE NOT NULL,
    create_at TIMESTAMP,
    total DECIMAL(10, 2),
    client_id INT,
    FOREIGN KEY (client_id ) REFERENCES client(id)
);

CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2),
    stock INT
);

CREATE TABLE IF NOT EXISTS datail (
    id SERIAL PRIMARY KEY,
    quantity INT NOT NULL,
    price DECIMAL(10, 2),
    invoice_id INT,
    product_id INT,
    FOREIGN KEY (invoice_id ) REFERENCES invoice(id),
    FOREIGN KEY (product_id ) REFERENCES product(id)
);