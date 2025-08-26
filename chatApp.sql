use chatapp;
create table users(
	id bigint primary key auto_increment,
    user_name varchar(100) not null unique,
    password_hash varchar(100) not null
);
create table conversations(
    id bigint primary key auto_increment,
    name varchar(100),
    type enum("private", "group"),
    room_owner bigint,
    created_at timestamp default current_timestamp,
    constraint fk_user_conversation foreign key (room_owner) references user(id)
);
-- tách từ bảng conversations
create table conversation_members(
    id bigint primary key auto_increment,
    conversation_id bigint not null,
    user_id bigint,
    constraint fk_user_conversation_member foreign key (user_id) references user(id),
    constraint fk_conversation_conversation_member foreign key (conversations_id) references conversations(id)
);
create table messages(
    id bigint primary key auto_increment,
    content longtext not null,
    send_by bigint,
    conversation_id bigint,
    created_at timestamp default current_timestamp,
    constraint fk_user_message foreign key (send_by) references user(id),
    constraint fk_message_conversation foreign key (conversation_id) references conversations(id),
    status enum('read','unread') default 'unread'
);