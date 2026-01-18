# Changelog

All notable changes to this project will be documented in this file.

The format is based on **Keep a Changelog** and this project adheres to **Semantic Versioning**.

---

## [1.0.0] - 2026-01-18
### Added
- Spring Boot REST API for food management (CRUD).
- H2 in-memory database with `data.sql` seed.
- Frontend UI using HTML/CSS/JavaScript served by Spring (`/static`).
- Filters:
    - All
    - Only expired
    - Expiring in 7 days
- Expiration status badges:
    - Expired
    - Expiring today
    - Expiring in X days
- Sorting:
    - Expiration date ascending
    - Secondary sort by name
- Full-row highlight for expired items.
- Validation handler for request errors.

### Changed
- Improved UI behavior:
    - Auto return to list after save
    - Proper form reset
    - Cleaner edit/new mode handling

### Fixed
- Data initialization order (H2 + schema generation before `data.sql`).
