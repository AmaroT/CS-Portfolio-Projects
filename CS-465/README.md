# Travlr Getaways - Full Stack MEAN Application

**CS 465 - Full Stack Development**

This repository contains the final full-stack MEAN (MongoDB, Express, Angular, Node.js) application for Travlr Getaways, a travel booking platform.

## Project Overview

The application consists of two main parts:

- **Customer-Facing Website**: Server-rendered with Express and Handlebars templates. Features dynamic trip listings with filtering by location and price.
- **Admin Single-Page Application (SPA)**: Built with Angular for managing trips (full CRUD: add, edit, delete).
- **Shared RESTful API**: Serves both frontends from the same backend.

## Architecture

### Frontend

- **Customer Site** (`app_server`): Server-side rendering with Handlebars (HBS) templates. Routes render HTML on the server using data from the API.
- **Admin Panel** (`travlr-admin`): Angular standalone SPA. Client-side rendering with reusable components and services.

### Backend

- **Node.js + Express**: Handles routing, API endpoints, and serving static files.
- **MongoDB**: NoSQL database with Mongoose models for flexible trip data storage.

### Data Flow

JSON serves as the interchange format between frontend and backend. The Express API returns JSON from MongoDB queries, consumed by both the Handlebars site (via internal requests) and the Angular admin SPA.

## Key Features

- Customer site: View trips, filter by location/price
- Admin SPA: Add, edit, delete trips with real-time updates
- Shared API endpoints: `/api/trips` and `/api/trips/:id`
- Data persistence in MongoDB

## Setup & Run

### Prerequisites
- Node.js
- MongoDB (local or Atlas)

### Run the Application

1. Start MongoDB (if local):
   ```bash
   brew services start mongodb-community
   ```
2. Start the Express backend:
    ```bash
    cd travlr
    npm install
    node app.js
    ```

- Customer site: http://localhost:3000/travel
- API: http://localhost:3000/api/trips

3. Start the Angular admin panel (in a new terminal):
    ```bash
    cd travlr-admin
    npm install
    ng serve
    ```

- Admin SPA: http://localhost:4200

## Repository Structure
    ```bash
    travlr/
├── app.js                  # Main Express server
├── app_api/                # REST API controllers and routes
├── app_server/             # Customer site (routes, controllers, views)
├── public/                 # Static assets (CSS, images)
├── package.json
└── README.md

travlr-admin/
├── src/app/                # Angular components, services, models
├── angular.json
└── package.json
    ```

## Reflection
This project demonstrated the full MEAN stack in action:
- Server-side rendering for fast initial loads
- Client-side SPA for rich admin interactions
- Shared API for code reuse
- NoSQL flexibility with MongoDB

Key learnings included separating concerns (API from frontends), using standalone Angular components, and integrating full CRUD operations with persistent data.

Author: Amaro Terrazas
Date: December 16, 2025







