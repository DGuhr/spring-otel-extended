create table if not exists animals
(
    id
    serial
    primary
    key,
    name
    text
    not
    null,
    type
    text
    not
    null
);

insert into animals (name, type)
values ('dog', 'mammal'),
       ('cat', 'mammal'),
       ('parrot', 'bird'),
       ('goldfish', 'fish'),
       ('whale', 'mammal'),
       ('shark', 'fish'),
       ('eagle', 'bird'),
       ('penguin', 'bird'),
       ('dolphin', 'mammal'),
       ('crocodile', 'reptile'),
       ('snake', 'reptile'),
       ('lizard', 'reptile'),
       ('iguana', 'reptile'),
       ('turtle', 'reptile'),
       ('frog', 'amphibian'),
       ('salamander', 'amphibian'),
       ('toad', 'amphibian'),
       ('newt', 'amphibian'),
       ('axolotl', 'amphibian');
