## comment_table_script
DROP TABLE IF EXISTS TEST;
CREATE TABLE TB_COMMENT(ID BIGINT PRIMARY KEY AUTO_INCREMENT,
PARENT_ID BIGINT NOT NULL,
TYPE INT NOT NULL,
COMMENTATOR INT NOT NULL,
GMT_CREATE BIGINT NOT NULL,
GMT_MODIFIED BIGINT NOT NULL,
LIKE_COUNT BIGINT DEFAULT 0
);

## MYBATIS GENERATOR COMMENT
mvn -'Dmybatis.generator.overwrite=true mybatis-generator:generate'


## notification_table_script
create table tb_notification
(
id bigint auto_increment primary key,
notifier bigint not null,
receiver bigint not null,
outerid bigint not null,
type int not null,
gmt_create bigint not null,
status int default 0 not null,
notifier_name varchar(100) null,
outer_title varchar(256) null
);