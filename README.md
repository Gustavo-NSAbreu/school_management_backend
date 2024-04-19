# Run this application

## Required software

**You must have Docker and Docker Compose installed.**

## Required configuration

Before running the project, you must create a `docker-compose.yaml` in the folder where both the repositories that this project depends on are, like this:

```
student-operations
|
|- docker-compose.yaml
|
|- studente_operations_backend
|
|- student-operations-frontend
```

The content of the docker compose must be:

```yaml
services:
  postgres:
    image: 'postgres'
    container_name: 'postgres'
    restart: always
    shm_size: 128mb
    volumes:
      - postgres:/var/lib/postgresql
    environment:
      - 'POSTGRES_DB=student_operations'
      - 'POSTGRES_PASSWORD=1234'
    ports:
      - 5432:5432
    networks:
      - school-management-network

  school-management-backend:
    image: school-management-backend
    container_name: school-management-backend
    build: ./school_management_backend
    ports:
      - "8000:8000"
    networks:
      - school-management-network

  school-management-frontend:
    image: school-management-frontend
    container_name: school-management-frontend
    build: ./school-management-frontend
    ports:
      - 3000:3000
    stdin_open: true
    tty: true
    networks:
      - school-management-network

networks:
  school-management-network:
    driver: bridge

volumes:
  postgres:
```

## Running

After setting up the file and repositories, run:

`docker compose up`

## Access the database

Run:

`docker exec -it postgres psql -h localhost -p 5432 -d school_management -U postgres`

## Access the interface

Go to: `localhost:3000`