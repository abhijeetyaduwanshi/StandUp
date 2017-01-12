ALTER TABLE ISSUE DROP FOREIGN KEY FK_ISSUE_PROJECT_ID
ALTER TABLE Retro DROP FOREIGN KEY FK_Retro_PROJECT_ID
ALTER TABLE guest_projects DROP FOREIGN KEY FK_guest_projects_guest_id
ALTER TABLE guest_projects DROP FOREIGN KEY FK_guest_projects_project_id
ALTER TABLE user_issues DROP FOREIGN KEY FK_user_issues_user_id
ALTER TABLE user_issues DROP FOREIGN KEY FK_user_issues_issue_id
ALTER TABLE user_projects DROP FOREIGN KEY FK_user_projects_user_id
ALTER TABLE user_projects DROP FOREIGN KEY FK_user_projects_project_id
ALTER TABLE user_retros DROP FOREIGN KEY FK_user_retros_retro_id
ALTER TABLE user_retros DROP FOREIGN KEY FK_user_retros_user_id
DROP TABLE GUEST
DROP TABLE ISSUE
DROP TABLE PROJECT
DROP TABLE Retro
DROP TABLE USER
DROP TABLE guest_projects
DROP TABLE user_issues
DROP TABLE user_projects
DROP TABLE user_retros
