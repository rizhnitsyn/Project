CREATE DATABASE hotel;
USE hotel;

CREATE TABLE users(id BIGINT AUTO_INCREMENT, first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL,
birthday DATE NOT NULL, gender VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL UNIQUE,
password VARCHAR(50) NOT NULL UNIQUE, phone_number BIGINT NOT NULL UNIQUE,
review  VARCHAR(50) NULL, evaluation VARCHAR(50) NULL, PRIMARY KEY(id));
CREATE TABLE roles (id BIGINT AUTO_INCREMENT, name VARCHAR(15) NOT NULL UNIQUE , PRIMARY KEY (id));
CREATE TABLE users_roles (user_id BIGINT, role_id BIGINT, PRIMARY KEY (user_id, role_id),
  FOREIGN KEY (user_id) REFERENCES users(id), FOREIGN KEY (role_id) REFERENCES roles(id));
CREATE TABLE additional_conveniences(id BIGINT AUTO_INCREMENT, title VARCHAR(50) NOT NULL UNIQUE, cost INT NOT NULL, PRIMARY KEY(id));
CREATE TABLE room_types(id BIGINT AUTO_INCREMENT, room_title VARCHAR(50) NOT NULL UNIQUE, cost_for_one_night INT NOT NULL, PRIMARY KEY(id));
CREATE TABLE facilities(id BIGINT AUTO_INCREMENT, title VARCHAR(50) NOT NULL UNIQUE, cost INT NOT NULL, PRIMARY KEY (id));
CREATE TABLE rooms(id BIGINT AUTO_INCREMENT, number_of_places INT NOT NULL, type_id BIGINT NOT NULL, PRIMARY KEY(id), FOREIGN KEY (type_id) REFERENCES room_types (id));
CREATE TABLE applications(id BIGINT AUTO_INCREMENT, room_id BIGINT NOT NULL, day_of_arrival DATE NOT NULL, day_of_departure DATE NOT NULL,
user_id BIGINT NOT NULL, PRIMARY KEY(id), FOREIGN KEY (user_id) REFERENCES users(id), FOREIGN KEY (room_id) REFERENCES rooms(id));
CREATE TABLE applications_conveniences(convenience_id BIGINT NOT NULL, application_id BIGINT NOT NULL, PRIMARY KEY (application_id, convenience_id),
FOREIGN KEY (convenience_id) REFERENCES additional_conveniences (id), FOREIGN KEY (application_id) REFERENCES applications (id));
CREATE TABLE rooms_facilities(room_id BIGINT NOT NULL, facility_id BIGINT NOT NULL, PRIMARY KEY (room_id, facility_id),
FOREIGN KEY (facility_id) REFERENCES facilities (id), FOREIGN KEY (room_id) REFERENCES rooms (id));

INSERT INTO users (first_name, last_name, birthday, gender, email, password, phone_number)
VALUES ('Alica', 'Morigan', '1990-03-26', 'FEMALE', 'alicamorigan@mail.ru', 'qwer', 1234567);
INSERT INTO users (first_name, last_name, birthday, gender, email, password, phone_number, review, evaluation)
VALUES ('Alex', 'Smoke', '1989-07-16', 'MALE', 'alexsmoke@mail.ru', 'asdf', 2345678, 'All was good!', 'EXCELLENT');
INSERT INTO users (first_name, last_name, birthday, gender, email, password, phone_number, review, evaluation)
VALUES ('Bob', 'Jobs', '1991-09-03', 'MALE', 'bobjobs@mail.ru', 'zxcv', 3456789, 'The best hotel in the world', 'EXCELLENT');
INSERT INTO users (first_name, last_name, birthday, gender, email, password, phone_number, review, evaluation)
VALUES ('Kate', 'Thompkins', '1990-02-20', 'FEMALE', 'katethompkins@mail.ru', 'tyui', 4567890, 'Not bad', 'ACCEPTABLE');

INSERT INTO roles (name) VALUES ('USER');
INSERT INTO roles (name) VALUES ('ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (4, 1);

INSERT INTO facilities (title, cost) VALUES ('balcony', 5);
INSERT INTO facilities (title, cost) VALUES ('bath', 10);
INSERT INTO facilities (title, cost) VALUES ('view from the window', 10);
INSERT INTO facilities (title, cost) VALUES ('soundproofing', 20);
INSERT INTO facilities (title, cost) VALUES ('air conditioning', 10);
INSERT INTO facilities (title, cost) VALUES ('coffee/tea maker', 5);
INSERT INTO facilities (title, cost) VALUES ('kitchen', 25);
INSERT INTO facilities (title, cost) VALUES ('washing machine', 10);
INSERT INTO facilities (title, cost) VALUES ('flat screen TV', 5);

INSERT INTO room_types (room_title, cost_for_one_night) VALUES ('lux', 100);
INSERT INTO room_types (room_title, cost_for_one_night) VALUES ('standard', 50);
INSERT INTO room_types (room_title, cost_for_one_night) VALUES ('economy', 25);

INSERT INTO additional_conveniences (title, cost) VALUES ('parking place', 20);
INSERT INTO additional_conveniences (title, cost) VALUES ('transfer from/to the airport', 15);
INSERT INTO additional_conveniences (title, cost) VALUES ('swimming pool', 20);
INSERT INTO additional_conveniences (title, cost) VALUES ('spa and wellness center', 30);
INSERT INTO additional_conveniences (title, cost) VALUES ('food and beverage delivery to the room', 5);

INSERT INTO rooms (number_of_places, type_id) VALUES (1, 1);
INSERT INTO rooms (number_of_places, type_id) VALUES (1, 1);
INSERT INTO rooms (number_of_places, type_id) VALUES (2, 1);
INSERT INTO rooms (number_of_places, type_id) VALUES (3, 1);
INSERT INTO rooms (number_of_places, type_id) VALUES (4, 1);

INSERT INTO rooms (number_of_places, type_id) VALUES (1, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (1, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (1, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (1, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (1, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (2, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (2, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (2, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (2, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (3, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (3, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (4, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (4, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (5, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (5, 2);
INSERT INTO rooms (number_of_places, type_id) VALUES (1, 3);
INSERT INTO rooms (number_of_places, type_id) VALUES (1, 3);
INSERT INTO rooms (number_of_places, type_id) VALUES (1, 3);
INSERT INTO rooms (number_of_places, type_id) VALUES (2, 3);
INSERT INTO rooms (number_of_places, type_id) VALUES (2, 3);
INSERT INTO rooms (number_of_places, type_id) VALUES (2, 3);
INSERT INTO rooms (number_of_places, type_id) VALUES (3, 3);
INSERT INTO rooms (number_of_places, type_id) VALUES (3, 3);
INSERT INTO rooms (number_of_places, type_id) VALUES (4, 3);
INSERT INTO rooms (number_of_places, type_id) VALUES (5, 3);

INSERT INTO applications (room_id, day_of_arrival, day_of_departure, user_id) VALUES (1, '2018-04-01', '2018-04-07', 2);
INSERT INTO applications (room_id, day_of_arrival, day_of_departure, user_id) VALUES (7, '2018-04-01', '2018-04-07', 2);
INSERT INTO applications (room_id, day_of_arrival, day_of_departure, user_id) VALUES (18, '2018-04-01', '2018-04-07', 2);
INSERT INTO applications (room_id, day_of_arrival, day_of_departure, user_id) VALUES (26, '2018-04-01', '2018-04-07', 3);
INSERT INTO applications (room_id, day_of_arrival, day_of_departure, user_id) VALUES (4, '2018-04-01', '2018-04-07', 3);
INSERT INTO applications (room_id, day_of_arrival, day_of_departure, user_id) VALUES (11, '2018-04-01', '2018-04-07', 3);
INSERT INTO applications (room_id, day_of_arrival, day_of_departure, user_id) VALUES (26, '2018-04-08', '2018-04-21', 4);
INSERT INTO applications (room_id, day_of_arrival, day_of_departure, user_id) VALUES (4, '2018-04-08', '2018-04-021', 4);
INSERT INTO applications (room_id, day_of_arrival, day_of_departure, user_id) VALUES (21, '2018-04-08', '2018-04-21', 4);

INSERT INTO applications_conveniences (convenience_id, application_id) VALUES (1, 1);
INSERT INTO applications_conveniences (convenience_id, application_id) VALUES (2, 2);
INSERT INTO applications_conveniences (convenience_id, application_id) VALUES (3, 4);
INSERT INTO applications_conveniences (convenience_id, application_id) VALUES (4, 1);
INSERT INTO applications_conveniences (convenience_id, application_id) VALUES (4, 2);
INSERT INTO applications_conveniences (convenience_id, application_id) VALUES (5, 1);
INSERT INTO applications_conveniences (convenience_id, application_id) VALUES (1, 3);


INSERT INTO rooms_facilities (room_id, facility_id) VALUES (1, 1);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (4, 1);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (7, 1);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (10, 1);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (13, 1);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (16, 1);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (19, 1);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (22, 1);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (25, 1);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (28, 1);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (2, 2);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (5, 2);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (8, 2);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (11, 2);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (14, 2);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (17, 2);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (20, 2);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (23, 2);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (26, 2);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (29, 2);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (3, 3);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (6, 3);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (9, 3);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (12, 3);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (15, 3);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (18, 3);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (21, 3);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (24, 3);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (27, 3);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (30, 3);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (1, 4);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (2, 4);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (5, 4);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (6, 4);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (9, 4);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (10, 4);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (13, 4);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (14, 4);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (17, 4);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (18, 4);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (11, 5);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (12, 5);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (15, 5);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (16, 5);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (19, 5);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (20, 5);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (23, 5);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (24, 5);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (27, 5);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (28, 5);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (21, 6);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (22, 6);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (25, 6);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (26, 6);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (29, 6);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (30, 6);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (3, 6);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (4, 6);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (7, 6);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (8, 6);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (1, 7);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (30, 7);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (3, 7);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (28, 7);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (5, 7);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (26, 7);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (7, 7);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (24, 7);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (9, 7);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (22, 7);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (2, 8);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (29, 8);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (4, 8);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (27, 8);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (6, 8);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (25, 8);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (8, 8);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (23, 8);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (10, 8);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (21, 8);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (3, 9);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (13, 9);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (5, 9);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (14, 9);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (7, 9);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (15, 9);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (17, 9);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (2, 9);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (18, 9);
INSERT INTO rooms_facilities (room_id, facility_id) VALUES (20, 9);

