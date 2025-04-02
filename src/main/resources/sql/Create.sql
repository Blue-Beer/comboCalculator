-- schema.sql

CREATE TABLE IF NOT EXISTS WEAPON_ACTION_UNIT (
    WEAPON_ID VARCHAR(4) NOT NULL,                  -- 适合存储武器ID
    ID VARCHAR(8) NOT NULL,                          -- 适合存储唯一ID，且作为主键
    NAME VARCHAR(32) NOT NULL,                        -- 适合存储名称
    ACTION_VALUE DECIMAL(5,2) DEFAULT 0.00,             -- 使用默认值0，适用于计算分析
    ELEMENT_RATE DECIMAL(5,2) DEFAULT 1.00,            -- 更精确地存储小数（最多5位数字，其中2位小数）
    SHARPNESS_CONSUME INT DEFAULT 10,                  -- 斩味消耗
    MIN_FRAME INT DEFAULT 1,                           -- 默认值0，适合用于计算和分析
    MAX_FRAME INT DEFAULT 180,                           -- 默认值0，适合用于计算和分析
    CRITICAL_CHECK BOOLEAN DEFAULT TRUE,              -- 能否会心
    HIT_ZONE_COUNT BOOLEAN DEFAULT TRUE,               -- 是否考虑肉质
    PRIMARY KEY (WEAPON_ID, ID)                        -- 联合主键：WEAPON_ID 和 ID 共同组成主键，确保唯一性
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS WEAPON_ACTION (
    ACTION_ID VARCHAR(32) NOT NULL,
    WEAPON_ID VARCHAR(4) NOT NULL,
    ACTION_NAME VARCHAR(32) NOT NULL,
    ACTION_UNITS DECIMAL(64) DEFAULT 0.00,
    PRIMARY KEY (ACTION_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

