# cicd-demo

A small Spring Boot 3 / Java 17 / Maven app built for practicing CI/CD.
No database, no external services, so pipelines stay simple.

## Endpoints
- `GET /api/hello?name=Ravi`  -> `{"message":"Hello, Ravi!"}`
- `GET /api/price?amount=200&discount=25` -> `{"finalPrice":150.00, ...}`
- `GET /actuator/health` -> `{"status":"UP"}`

## Run locally
    mvn spring-boot:run
    mvn verify                     # tests + JaCoCo report (target/site/jacoco/index.html)
    docker build -t cicd-demo .    # needed from Phase 4
    docker run -p 8080:8080 cicd-demo

## Setup for the roadmap
1. Create a GitHub repo, then push this project:
       git init && git add . && git commit -m "initial commit"
       git branch -M main
       git remote add origin <your-repo-url> && git push -u origin main
2. Phase 2: create `.github/workflows/ci.yml` yourself (that is the exercise).
3. Phase 3: add JaCoCo coverage thresholds and Checkstyle to the pom.
4. Phase 4: use the included Dockerfile and push to GHCR.

## Practice ideas
- Break a test on a branch and watch the pipeline fail on the PR.
- Add a new endpoint with tests and see coverage change.
- Add a failing-on-purpose step and practice reading logs.
