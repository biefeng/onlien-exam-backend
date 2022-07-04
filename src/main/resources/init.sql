DELETE FROM USER;
DELETE FROM PAGE;
DELETE FROM ROLE;
DELETE FROM question_level;
DELETE FROM ACTION;
DELETE FROM  question_type;

INSERT INTO "USER" (USER_ID,CREATE_TIME,UPDATE_TIME,USER_AVATAR,USER_DESCRIPTION,USER_EMAIL,USER_NICKNAME,USER_PASSWORD,USER_PHONE,USER_ROLE_ID,USER_USERNAME) VALUES
	 ('6a4a7ba7d94f4b87a1cf7f744f903f18',NULL,NULL,'http://d.lanrentuku.com/down/png/1904/business_avatar/8_avatar_2754583.png','welcome to online exam system','335049213@qq.com','user_13297036046','YmllZmVuZzEyMw==','13297036046',1,'user_13297036046');


INSERT INTO `page`(PAGE_ID , PAGE_NAME ,PAGE_DESCRIPTION ,ACTION_IDS ) VALUES ('1', 'dashboard', '仪表盘', '1-2-3-4-5');
INSERT INTO `page`(PAGE_ID , PAGE_NAME ,PAGE_DESCRIPTION ,ACTION_IDS )  VALUES ('2', 'exam-card', '考试列表', '1-6-3-4');
INSERT INTO `page`(PAGE_ID , PAGE_NAME ,PAGE_DESCRIPTION ,ACTION_IDS )  VALUES ('3', 'exam-record-list', '考试记录', '1-6-3-4');
INSERT INTO `page`(PAGE_ID , PAGE_NAME ,PAGE_DESCRIPTION ,ACTION_IDS )  VALUES ('4', 'question-admin', '问题管理', '1-6-3-4');
INSERT INTO `page`(PAGE_ID , PAGE_NAME ,PAGE_DESCRIPTION ,ACTION_IDS )  VALUES ('5', 'exam-table-list', '考试管理', '1-6-3-4');
INSERT INTO `page` (PAGE_ID , PAGE_NAME ,PAGE_DESCRIPTION ,ACTION_IDS ) VALUES ('6', 'user', '个人页', '1-6-3-4-5-7');

INSERT INTO `role`(ROLE_ID ,ROLE_NAME ,ROLE_DETAIL ,ROLE_DESCRIPTION ,ROLE_PAGE_IDS ) VALUES ('1', 'admin', '管理员', '拥有教师和学生的所有权限', '1-2-3-4-5-6');
INSERT INTO `role` (ROLE_ID ,ROLE_NAME ,ROLE_DETAIL ,ROLE_DESCRIPTION ,ROLE_PAGE_IDS ) VALUES ('2', 'teacher', '教师', '出题、组试卷、管理学生和试卷', '1-2-3-4-5-6');
INSERT INTO `role`(ROLE_ID ,ROLE_NAME ,ROLE_DETAIL ,ROLE_DESCRIPTION ,ROLE_PAGE_IDS )  VALUES ('3', 'student', '学生', '参与考试，查看分数', '1-2-3-6');

INSERT INTO `question_level`(QUESTION_LEVEL_ID ,QUESTION_LEVEL_NAME ,QUESTION_LEVEL_DESCRIPTION ) VALUES ('1', 'high', '难');
INSERT INTO `question_level`(QUESTION_LEVEL_ID ,QUESTION_LEVEL_NAME ,QUESTION_LEVEL_DESCRIPTION ) VALUES ('2', 'middle', '中');
INSERT INTO `question_level`(QUESTION_LEVEL_ID ,QUESTION_LEVEL_NAME ,QUESTION_LEVEL_DESCRIPTION ) VALUES ('3', 'low', '易');


INSERT INTO `action`(ACTION_ID ,ACTION_NAME ,ACTION_DESCRIPTION ,DEFAULT_CHECK ) VALUES ('1', 'add', '新增', '0');
INSERT INTO `action` (ACTION_ID ,ACTION_NAME ,ACTION_DESCRIPTION ,DEFAULT_CHECK ) VALUES ('2', 'query', '查询', '0');
INSERT INTO `action`(ACTION_ID ,ACTION_NAME ,ACTION_DESCRIPTION ,DEFAULT_CHECK )  VALUES ('3', 'get', '详情', '0');
INSERT INTO `action`(ACTION_ID ,ACTION_NAME ,ACTION_DESCRIPTION ,DEFAULT_CHECK )  VALUES ('4', 'update', '修改', '0');
INSERT INTO `action`(ACTION_ID ,ACTION_NAME ,ACTION_DESCRIPTION ,DEFAULT_CHECK )  VALUES ('5', 'delete', '删除', '0');
INSERT INTO `action` (ACTION_ID ,ACTION_NAME ,ACTION_DESCRIPTION ,DEFAULT_CHECK ) VALUES ('6', 'import', '导入', '0');
INSERT INTO `action` (ACTION_ID ,ACTION_NAME ,ACTION_DESCRIPTION ,DEFAULT_CHECK ) VALUES ('7', 'export', '导出', '0');

INSERT INTO `question_type`(QUESTION_TYPE_ID ,QUESTION_TYPE_NAME ,QUESTION_TYPE_DESCRIPTION ) VALUES ('1', 'single', '单选题');
INSERT INTO `question_type`(QUESTION_TYPE_ID ,QUESTION_TYPE_NAME ,QUESTION_TYPE_DESCRIPTION )  VALUES ('2', 'multi', '多选题');
INSERT INTO `question_type` (QUESTION_TYPE_ID ,QUESTION_TYPE_NAME ,QUESTION_TYPE_DESCRIPTION ) VALUES ('3', 'judge', '判断题');