FROM postgres

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD dac
ENV POSTGRES_DB session-beans

COPY tabelas.sql /docker-entrypoint-initdb.d/
