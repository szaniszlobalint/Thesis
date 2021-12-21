#!/bin/bash
psql postgresql://postgres:docker@localhost:5432/redmineapp1 << EOF
INSERT INTO settings(id, name, value) VALUES(1,'rest_api_enabled',1);
INSERT INTO settings(id, name, value) VALUES(2,'jsonp_enabled',0);

INSERT INTO users(id,login,hashed_password,firstname,lastname,admin,status,type,mail_notification,must_change_passwd)
VALUES(5, 'szekeres', '12345678', 'Lajos', 'Szekeres', false, 1, 'User','', false);
INSERT INTO users(id,login,hashed_password,firstname,lastname,admin,status,type,mail_notification,must_change_passwd)
VALUES(6, 'kerekes', '12345678', 'Laszlo', 'Kerekes', false, 1, 'User', '', false);
INSERT INTO users(id,login,hashed_password,firstname,lastname,admin,status,type,mail_notification,must_change_passwd)
VALUES(7, 'szabo', '12345678', 'David', 'Szabo', false, 1, 'User','', false);

INSERT INTO projects(id,name,is_public, identifier, status, lft, rgt, inherit_members) VALUES(1, 'Test', true, 'test', 1, 1, 2, false);
INSERT INTO projects(id,name,is_public, identifier, status, lft, rgt, inherit_members) VALUES(2, 'Another Project', true, 'another-project', 1, 3, 4, false);
INSERT INTO projects(id,name,is_public, identifier, status, lft, rgt, inherit_members) VALUES(3, 'Important Project', true, 'important-project', 1, 5, 6, false);

INSERT INTO enabled_modules(id, project_id, name) VALUES(1, 1, 'issue_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(2, 1, 'time_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(3, 1, 'news');
INSERT INTO enabled_modules(id, project_id, name) VALUES(4, 1, 'documents');
INSERT INTO enabled_modules(id, project_id, name) VALUES(5, 1, 'files');
INSERT INTO enabled_modules(id, project_id, name) VALUES(6, 1, 'wiki');
INSERT INTO enabled_modules(id, project_id, name) VALUES(7, 1, 'repository');
INSERT INTO enabled_modules(id, project_id, name) VALUES(8, 1, 'boards');
INSERT INTO enabled_modules(id, project_id, name) VALUES(9, 1, 'calendar');
INSERT INTO enabled_modules(id, project_id, name) VALUES(10, 1, 'gantt');

INSERT INTO enabled_modules(id, project_id, name) VALUES(11, 2, 'issue_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(12, 2, 'time_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(13, 2, 'news');
INSERT INTO enabled_modules(id, project_id, name) VALUES(14, 2, 'documents');
INSERT INTO enabled_modules(id, project_id, name) VALUES(15, 2, 'files');
INSERT INTO enabled_modules(id, project_id, name) VALUES(16, 2, 'wiki');
INSERT INTO enabled_modules(id, project_id, name) VALUES(17, 2, 'repository');
INSERT INTO enabled_modules(id, project_id, name) VALUES(18, 2, 'boards');
INSERT INTO enabled_modules(id, project_id, name) VALUES(19, 2, 'calendar');
INSERT INTO enabled_modules(id, project_id, name) VALUES(20, 2, 'gantt');

INSERT INTO enabled_modules(id, project_id, name) VALUES(21, 3, 'issue_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(22, 3, 'time_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(23, 3, 'news');
INSERT INTO enabled_modules(id, project_id, name) VALUES(24, 3, 'documents');
INSERT INTO enabled_modules(id, project_id, name) VALUES(25, 3, 'files');
INSERT INTO enabled_modules(id, project_id, name) VALUES(26, 3, 'wiki');
INSERT INTO enabled_modules(id, project_id, name) VALUES(27, 3, 'repository');
INSERT INTO enabled_modules(id, project_id, name) VALUES(28, 3, 'boards');
INSERT INTO enabled_modules(id, project_id, name) VALUES(29, 3, 'calendar');
INSERT INTO enabled_modules(id, project_id, name) VALUES(30, 3, 'gantt');

INSERT INTO trackers(id, name, is_in_chlog, position, is_in_roadmap, fields_bits, default_status_id) VALUES(1, 'tracker', false, 1, true, 0, 1);

INSERT INTO issue_statuses(id, name, is_closed, position) VALUES(1, 'In Progress', false, 1);
INSERT INTO issue_statuses(id, name, is_closed, position) VALUES(2, 'Done', false, 2);

INSERT INTO enumerations(id, name, position, is_default, type, active, position_name) VALUES(1, 'Low', 1, true, 'IssuePriority', true, 'default');
INSERT INTO enumerations(id, name, position, is_default, type, active, position_name) VALUES(2, 'High', 2, true, 'IssuePriority', true, 'highest');

INSERT INTO projects_trackers(project_id, tracker_id) VALUES(1, 1);
INSERT INTO projects_trackers(project_id, tracker_id) VALUES(2, 1);
INSERT INTO projects_trackers(project_id, tracker_id) VALUES(3, 1);

INSERT INTO roles(id, name, position,assignable, builtin, permissions, issues_visibility, users_visibility, time_entries_visibility, all_roles_managed, settings)
VALUES (3, 'All', 1, true, 0, '---
- :add_project
- :edit_project
- :close_project
- :delete_project
- :select_project_modules
- :manage_members
- :manage_versions
- :add_subprojects
- :manage_public_queries
- :save_queries
- :view_messages
- :add_messages
- :edit_messages
- :edit_own_messages
- :delete_messages
- :delete_own_messages
- :view_message_watchers
- :add_message_watchers
- :delete_message_watchers
- :manage_boards
- :view_calendar
- :view_documents
- :add_documents
- :edit_documents
- :delete_documents
- :view_files
- :manage_files
- :view_gantt
- :view_issues
- :add_issues
- :edit_issues
- :edit_own_issues
- :copy_issues
- :manage_issue_relations
- :manage_subtasks
- :set_issues_private
- :set_own_issues_private
- :add_issue_notes
- :edit_issue_notes
- :edit_own_issue_notes
- :view_private_notes
- :set_notes_private
- :delete_issues
- :view_issue_watchers
- :add_issue_watchers
- :delete_issue_watchers
- :import_issues
- :manage_categories
- :view_news
- :manage_news
- :comment_news
- :view_changesets
- :browse_repository
- :commit_access
- :manage_related_issues
- :manage_repository
- :view_time_entries
- :log_time
- :edit_time_entries
- :edit_own_time_entries
- :manage_project_activities
- :log_time_for_other_users
- :import_time_entries
- :view_wiki_pages
- :view_wiki_edits
- :export_wiki_pages
- :edit_wiki_pages
- :rename_wiki_pages
- :delete_wiki_pages
- :delete_wiki_pages_attachments
- :protect_wiki_pages
- :manage_wiki', 'all', 'all', 'all', true, '--- !ruby/hash:ActiveSupport::HashWithIndifferentAccess
permissions_all_trackers: !ruby/hash:ActiveSupport::HashWithIndifferentAccess
view_issues: 1
add_issues: 1
edit_issues: 1
add_issue_notes: 1
delete_issues: 1
permissions_tracker_ids: !ruby/hash:ActiveSupport::HashWithIndifferentAccess
view_issues: []
add_issues: []
edit_issues: []
add_issue_notes: []
delete_issues: []');

INSERT INTO workflows(id, tracker_id, old_status_id, new_status_id, role_id, assignee, author, type) VALUES(1, 1, 0, 1, 3, false, false, 'WorkflowTransition');
INSERT INTO workflows(id, tracker_id, old_status_id, new_status_id, role_id, assignee, author, type) VALUES(2, 1, 0, 2, 3, false, false, 'WorkflowTransition');

INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(1, 1, 1, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(2, 5, 1, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(3, 6, 1, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(4, 7, 1, false);

INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(5, 1, 2, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(6, 5, 2, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(7, 6, 2, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(8, 7, 2, false);

INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(9, 1, 3, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(10, 5, 3, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(11, 6, 3, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(12, 7, 3, false);

INSERT INTO member_roles(id, member_id, role_id) VALUES(1, 1, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(2, 2, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(3, 3, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(4, 4, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(5, 5, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(6, 6, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(7, 7, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(8, 8, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(9, 9, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(10, 10, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(11, 11, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(12, 12, 3);

INSERT INTO issues(id, tracker_id, project_id, subject, status_id, assigned_to_id, priority_id, author_id, lock_version, done_ratio, root_id, lft, rgt, is_private)
VALUES(1, 1, 1, 'Test Issue', 1, 5, 1, 1, 0, 0, 1, 1, 2, false);
INSERT INTO issues(id, tracker_id, project_id, subject, status_id, assigned_to_id, priority_id, author_id, lock_version, done_ratio, root_id, lft, rgt, is_private)
VALUES(2, 1, 2, 'Another Issue', 1, 6, 1, 1, 0, 0, 1, 3, 4, false);
INSERT INTO issues(id, tracker_id, project_id, subject, status_id, assigned_to_id, priority_id, author_id, lock_version, done_ratio, root_id, lft, rgt, is_private)
VALUES(3, 1, 3, 'Important Issue', 1, 7, 1, 1, 0, 0, 1, 5, 6, false);
EOF

psql postgresql://postgres:docker@localhost:5432/redmineapp2 << EOF
INSERT INTO settings(id, name, value) VALUES(1,'rest_api_enabled',1);
INSERT INTO settings(id, name, value) VALUES(2,'jsonp_enabled',0);

INSERT INTO users(id,login,hashed_password,firstname,lastname,admin,status,type,mail_notification,must_change_passwd)
VALUES(5, 'szekeres', '12345678', 'Lajos', 'Szekeres', false, 1, 'User','', false);
INSERT INTO users(id,login,hashed_password,firstname,lastname,admin,status,type,mail_notification,must_change_passwd)
VALUES(6, 'kerekes', '12345678', 'Laszlo', 'Kerekes', false, 1, 'User', '', false);
INSERT INTO users(id,login,hashed_password,firstname,lastname,admin,status,type,mail_notification,must_change_passwd)
VALUES(7, 'szabo', '12345678', 'David', 'Szabo', false, 1, 'User','', false);

INSERT INTO projects(id,name,is_public, identifier, status, lft, rgt, inherit_members) VALUES(1, 'Test', true, 'test', 1, 1, 2, false);
INSERT INTO projects(id,name,is_public, identifier, status, lft, rgt, inherit_members) VALUES(2, 'Another Project', true, 'another-project', 1, 3, 4, false);
INSERT INTO projects(id,name,is_public, identifier, status, lft, rgt, inherit_members) VALUES(3, 'Important Project', true, 'important-project', 1, 5, 6, false);

INSERT INTO enabled_modules(id, project_id, name) VALUES(1, 1, 'issue_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(2, 1, 'time_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(3, 1, 'news');
INSERT INTO enabled_modules(id, project_id, name) VALUES(4, 1, 'documents');
INSERT INTO enabled_modules(id, project_id, name) VALUES(5, 1, 'files');
INSERT INTO enabled_modules(id, project_id, name) VALUES(6, 1, 'wiki');
INSERT INTO enabled_modules(id, project_id, name) VALUES(7, 1, 'repository');
INSERT INTO enabled_modules(id, project_id, name) VALUES(8, 1, 'boards');
INSERT INTO enabled_modules(id, project_id, name) VALUES(9, 1, 'calendar');
INSERT INTO enabled_modules(id, project_id, name) VALUES(10, 1, 'gantt');

INSERT INTO enabled_modules(id, project_id, name) VALUES(11, 2, 'issue_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(12, 2, 'time_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(13, 2, 'news');
INSERT INTO enabled_modules(id, project_id, name) VALUES(14, 2, 'documents');
INSERT INTO enabled_modules(id, project_id, name) VALUES(15, 2, 'files');
INSERT INTO enabled_modules(id, project_id, name) VALUES(16, 2, 'wiki');
INSERT INTO enabled_modules(id, project_id, name) VALUES(17, 2, 'repository');
INSERT INTO enabled_modules(id, project_id, name) VALUES(18, 2, 'boards');
INSERT INTO enabled_modules(id, project_id, name) VALUES(19, 2, 'calendar');
INSERT INTO enabled_modules(id, project_id, name) VALUES(20, 2, 'gantt');

INSERT INTO enabled_modules(id, project_id, name) VALUES(21, 3, 'issue_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(22, 3, 'time_tracking');
INSERT INTO enabled_modules(id, project_id, name) VALUES(23, 3, 'news');
INSERT INTO enabled_modules(id, project_id, name) VALUES(24, 3, 'documents');
INSERT INTO enabled_modules(id, project_id, name) VALUES(25, 3, 'files');
INSERT INTO enabled_modules(id, project_id, name) VALUES(26, 3, 'wiki');
INSERT INTO enabled_modules(id, project_id, name) VALUES(27, 3, 'repository');
INSERT INTO enabled_modules(id, project_id, name) VALUES(28, 3, 'boards');
INSERT INTO enabled_modules(id, project_id, name) VALUES(29, 3, 'calendar');
INSERT INTO enabled_modules(id, project_id, name) VALUES(30, 3, 'gantt');

INSERT INTO trackers(id, name, is_in_chlog, position, is_in_roadmap, fields_bits, default_status_id) VALUES(1, 'tracker', false, 1, true, 0, 1);

INSERT INTO issue_statuses(id, name, is_closed, position) VALUES(1, 'In Progress', false, 1);
INSERT INTO issue_statuses(id, name, is_closed, position) VALUES(2, 'Done', false, 2);

INSERT INTO enumerations(id, name, position, is_default, type, active, position_name) VALUES(1, 'Low', 1, true, 'IssuePriority', true, 'default');
INSERT INTO enumerations(id, name, position, is_default, type, active, position_name) VALUES(2, 'High', 2, true, 'IssuePriority', true, 'highest');

INSERT INTO projects_trackers(project_id, tracker_id) VALUES(1, 1);
INSERT INTO projects_trackers(project_id, tracker_id) VALUES(2, 1);
INSERT INTO projects_trackers(project_id, tracker_id) VALUES(3, 1);

INSERT INTO roles(id, name, position,assignable, builtin, permissions, issues_visibility, users_visibility, time_entries_visibility, all_roles_managed, settings)
VALUES (3, 'All', 1, true, 0, '---
- :add_project
- :edit_project
- :close_project
- :delete_project
- :select_project_modules
- :manage_members
- :manage_versions
- :add_subprojects
- :manage_public_queries
- :save_queries
- :view_messages
- :add_messages
- :edit_messages
- :edit_own_messages
- :delete_messages
- :delete_own_messages
- :view_message_watchers
- :add_message_watchers
- :delete_message_watchers
- :manage_boards
- :view_calendar
- :view_documents
- :add_documents
- :edit_documents
- :delete_documents
- :view_files
- :manage_files
- :view_gantt
- :view_issues
- :add_issues
- :edit_issues
- :edit_own_issues
- :copy_issues
- :manage_issue_relations
- :manage_subtasks
- :set_issues_private
- :set_own_issues_private
- :add_issue_notes
- :edit_issue_notes
- :edit_own_issue_notes
- :view_private_notes
- :set_notes_private
- :delete_issues
- :view_issue_watchers
- :add_issue_watchers
- :delete_issue_watchers
- :import_issues
- :manage_categories
- :view_news
- :manage_news
- :comment_news
- :view_changesets
- :browse_repository
- :commit_access
- :manage_related_issues
- :manage_repository
- :view_time_entries
- :log_time
- :edit_time_entries
- :edit_own_time_entries
- :manage_project_activities
- :log_time_for_other_users
- :import_time_entries
- :view_wiki_pages
- :view_wiki_edits
- :export_wiki_pages
- :edit_wiki_pages
- :rename_wiki_pages
- :delete_wiki_pages
- :delete_wiki_pages_attachments
- :protect_wiki_pages
- :manage_wiki', 'all', 'all', 'all', true, '--- !ruby/hash:ActiveSupport::HashWithIndifferentAccess
permissions_all_trackers: !ruby/hash:ActiveSupport::HashWithIndifferentAccess
view_issues: 1
add_issues: 1
edit_issues: 1
add_issue_notes: 1
delete_issues: 1
permissions_tracker_ids: !ruby/hash:ActiveSupport::HashWithIndifferentAccess
view_issues: []
add_issues: []
edit_issues: []
add_issue_notes: []
delete_issues: []');

INSERT INTO workflows(id, tracker_id, old_status_id, new_status_id, role_id, assignee, author, type) VALUES(1, 1, 0, 1, 3, false, false, 'WorkflowTransition');
INSERT INTO workflows(id, tracker_id, old_status_id, new_status_id, role_id, assignee, author, type) VALUES(2, 1, 0, 2, 3, false, false, 'WorkflowTransition');

INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(1, 1, 1, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(2, 5, 1, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(3, 6, 1, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(4, 7, 1, false);

INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(5, 1, 2, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(6, 5, 2, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(7, 6, 2, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(8, 7, 2, false);

INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(9, 1, 3, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(10, 5, 3, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(11, 6, 3, false);
INSERT INTO members(id, user_id, project_id, mail_notification) VALUES(12, 7, 3, false);

INSERT INTO member_roles(id, member_id, role_id) VALUES(1, 1, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(2, 2, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(3, 3, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(4, 4, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(5, 5, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(6, 6, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(7, 7, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(8, 8, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(9, 9, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(10, 10, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(11, 11, 3);
INSERT INTO member_roles(id, member_id, role_id) VALUES(12, 12, 3);

INSERT INTO issues(id, tracker_id, project_id, subject, status_id, assigned_to_id, priority_id, author_id, lock_version, done_ratio, root_id, lft, rgt, is_private)
VALUES(1, 1, 1, 'Test Issue', 1, 5, 1, 1, 0, 0, 1, 1, 2, false);
INSERT INTO issues(id, tracker_id, project_id, subject, status_id, assigned_to_id, priority_id, author_id, lock_version, done_ratio, root_id, lft, rgt, is_private)
VALUES(2, 1, 2, 'Another Issue', 1, 6, 1, 1, 0, 0, 1, 3, 4, false);
INSERT INTO issues(id, tracker_id, project_id, subject, status_id, assigned_to_id, priority_id, author_id, lock_version, done_ratio, root_id, lft, rgt, is_private)
VALUES(3, 1, 3, 'Important Issue', 1, 7, 1, 1, 0, 0, 1, 5, 6, false);
EOF
exit $?