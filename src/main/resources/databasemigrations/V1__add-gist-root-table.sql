CREATE TABLE gist_root (
    id uuid PRIMARY KEY,
    location character varying(255) NOT NULL,
    members jsonb
);

