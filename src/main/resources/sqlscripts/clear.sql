TRUNCATE TABLE roles CASCADE;
ALTER SEQUENCE roles_id_seq RESTART WITH 1;

TRUNCATE TABLE privileges CASCADE;
ALTER SEQUENCE privileges_id_seq RESTART WITH 1;

TRUNCATE TABLE users CASCADE;

TRUNCATE TABLE mentors CASCADE;

TRUNCATE TABLE classes CASCADE;
ALTER SEQUENCE classes_id_seq RESTART WITH 1;

TRUNCATE TABLE wallets CASCADE;
ALTER SEQUENCE wallets_id_seq RESTART WITH 1;

TRUNCATE TABLE quests CASCADE;
ALTER SEQUENCE quests_id_seq RESTART WITH 1;

TRUNCATE TABLE artifacts CASCADE;
ALTER SEQUENCE artifacts_id_seq RESTART WITH 1;

TRUNCATE TABLE wallet_artifacts CASCADE;