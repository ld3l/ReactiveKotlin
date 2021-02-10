CREATE TABLE users (
                        id SERIAL PRIMARY KEY,
                        name TEXT NOT NULL
);

CREATE TABLE orders (
                       id SERIAL PRIMARY KEY,
                       order_number INT NOT NULL,
                       description TEXT NOT NULL,
                       user_id INT NOT NULL,
                       CONSTRAINT fk_users
                           FOREIGN KEY(user_id)
                               REFERENCES users(id)
);