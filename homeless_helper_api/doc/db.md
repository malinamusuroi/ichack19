Run psql

```
postgres -D /usr/local/var/postgres
```

Create db

```postgresql
psql
CREATE ROLE ichack WITH LOGIN PASSWORD 'ichack';
ALTER ROLE ichack CREATEDB;
CREATE DATABASE ichackdb;
GRANT ALL PRIVILEGES ON DATABASE ichackdb TO ichack;
```

Delete db

```postgresql

psql
DROP DATABASE ichackdb;
CREATE DATABASE ichackdb;
GRANT ALL PRIVILEGES ON DATABASE ichackdb TO ichack;
```

View db

```postgresql
psql ichackdb
\dt

```