# CS 465 Module Eight Journal Reflection

### Architecture

In the Travlr Getaways project, I used three different frontend approaches. The customer-facing site was built with Express and Handlebars for server-side rendering. This meant HTML was generated on the server for each request, providing fast initial loads and good SEO, but navigation involved full page reloads. I also used plain JavaScript for small interactive features like form validation in early modules. The admin panel was a single-page application (SPA) built with Angular. After the initial page load, all rendering and routing happened client-side, resulting in a smooth, more responsive experience with no page refreshes during admin tasks.

The backend used MongoDB, a NoSQL database, because the data structure for trips was flexible and expected to evolve. Fields like imageUrl or duration could be added later without schema migrations. MongoDB's document model stores data as JSON-like objects, making it natural to work with JavaScript across the entire stack and simplifying queries for filtering trips.

### Functionality

JSON (JavaScript Object Notation) is a lightweight data format for exchanging information, consisting of key-value pairs. It is different from JavaScript in that it is language-independent and used primarily for data transmission, while JavaScript is a full programming language. In this project, JSON served as the bridge between frontend and backend. The Express API returned JSON from MongoDB queries, and both the Handlebars customer site (via internal requests) and Angular admin SPA consumed that JSON through HTTP calls.

I refactored code several times for better functionality and efficiency. I moved trip data access from a static JSON file to Mongoose models for real persistence. I separated the REST API into its own `app_api` folder to avoid duplication and allow reuse by both frontends. In Angular, I created a reusable `TripCardComponent` to display trips, reducing repeated HTML and CSS. Reusable UI components provided consistency, faster development, and easier maintenance — a single change updated the appearance everywhere.

### Testing

Full-stack testing involved verifying API endpoints and their integration with frontends. I used Postman to test GET `/api/trips` for the list, GET `/api/trips/:id` for individual trips, POST for adding, PUT for updating, and DELETE for removal, ensuring correct status codes and payloads. In the browser, I tested the Angular SPA by performing CRUD operations and refreshing to confirm data persisted in MongoDB. Adding JWT authentication introduced challenges like testing protected routes with valid/invalid tokens and verifying unauthorized requests received 401 responses. These tests ensured secure, end-to-end data flow across all layers.

### Reflection

This course has significantly advanced my goal of becoming a full-stack developer. Starting with basic Express/Handlebars sites, I progressed to building complete MEAN applications with real databases, separated APIs, and modern Angular SPAs with authentication. I mastered MongoDB modeling, REST API design, Angular standalone components, JWT security, and full CRUD integration. The hands-on progression gave me practical experience with the entire development lifecycle.

These skills make me more marketable: I can now deliver scalable, secure web applications using JavaScript across the stack — a common requirement in job postings. Having a complete Travlr Getaways project in my portfolio demonstrates not just theoretical knowledge but the ability to execute and troubleshoot complex full-stack systems.

**GitHub Repository:** https://github.com/AmaroT/CS-Portfolio-Projects/tree/main/CS-465/travlr

