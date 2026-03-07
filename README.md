<h1 align="center">Secure Product Management System</h1>

<p align="center">
  A RESTful API project built with <b>Spring Boot 3</b>. This application goes beyond basic CRUD by implementing <b>Spring Security with JWT (JSON Web Tokens)</b> for stateless authentication, <b>MySQL</b> for persistent data storage, and provides interactive API documentation using <b>Swagger (OpenAPI 3.0)</b>.
</p>

<hr>

<h2>Tech Stack</h2>
<ul>
  <li><b>Java 21</b></li>
  <li><b>Spring Boot 3</b> (Web, Data JPA, Security)</li>
  <li><b>Spring Security & JWT</b> (Stateless Authentication & Authorization)</li>
  <li><b>SpringDoc OpenAPI (Swagger UI)</b> (Interactive API Documentation)</li>
  <li><b>MySQL</b> (Production-ready Database) / <b>H2</b> (In-memory testing)</li>
  <li><b>Spring Data JPA</b> (ORM & Repository Pattern)</li>
  <li><b>Lombok</b> (Boilerplate reduction)</li>
  <li><b>Maven</b> (Dependency Management)</li>
</ul>

<h2>Key Features</h2>
<ul>
  <li><b>User Management:</b> User registration and secure password storage using <b>Bcrypt Password Encoder</b>.</li>
  <li><b>Stateless Authentication (JWT):</b> Secure login mechanism that generates and validates JSON Web Tokens.</li>
  <li><b>Interactive API Documentation:</b> Auto-generated Swagger UI for exploring and testing API endpoints directly in the browser, fully configured to support JWT Bearer authorization.</li>
  <li><b>Product Management:</b> Full CRUD operations for products.</li>
  <li><b>Data Relationship:</b> One-to-Many relationship (Users own Products). When a product is added, it is automatically linked to the authenticated user.</li>
  <li><b>Security:</b> Custom <code>JwtFilter</code> to intercept requests and validate bearer tokens. CSRF is disabled as the application relies on stateless JWT authentication.</li>
</ul>

<h2>API Endpoints</h2>
<p>You can view and test all endpoints interactively via the Swagger UI (see testing instructions below).</p>

<table width="100%">
  <thead>
    <tr>
      <th align="left">HTTP Method</th>
      <th align="left">Path</th>
      <th align="left">Description</th>
      <th align="left">Auth Required</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code>POST</code></td>
      <td><code>/register</code></td>
      <td>Register a new user</td>
      <td>No</td>
    </tr>
    <tr>
      <td><code>POST</code></td>
      <td><code>/login</code></td>
      <td>Authenticate user and receive a JWT token</td>
      <td>No</td>
    </tr>
    <tr>
      <td><code>GET</code></td>
      <td><code>/products</code></td>
      <td>Retrieve all products</td>
      <td>Yes (JWT)</td>
    </tr>
    <tr>
      <td><code>GET</code></td>
      <td><code>/products/{id}</code></td>
      <td>Retrieve a specific product by ID</td>
      <td>Yes (JWT)</td>
    </tr>
    <tr>
      <td><code>POST</code></td>
      <td><code>/products</code></td>
      <td>Add a new product (Automatically linked to current User)</td>
      <td>Yes (JWT)</td>
    </tr>
    <tr>
      <td><code>PUT</code></td>
      <td><code>/products</code></td>
      <td>Update an existing product</td>
      <td>Yes (JWT)</td>
    </tr>
    <tr>
      <td><code>DELETE</code></td>
      <td><code>/products/{id}</code></td>
      <td>Delete a specific product</td>
      <td>Yes (JWT)</td>
    </tr>
  </tbody>
</table>

<h2>Database Configuration</h2>

<p>This project is configured to use <b>MySQL</b> by default. Update <code>src/main/resources/application.properties</code> with your database credentials.</p>

<h3>1. MySQL Setup</h3>
<p>Create a database named <code>userdetails</code>:</p>
<pre><code>CREATE DATABASE userdetails;</code></pre>

<p>Update <code>application.properties</code>:</p>
<pre><code>spring.datasource.url=jdbc:mysql://localhost:3306/userdetails
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update</code></pre>

<h2>How to Run & Test</h2>

<h3>1. Clone and Run</h3>
<pre><code>git clone https://github.com/tzuhuanl/Product-Management-System.git
cd Product-Management-System
mvn spring-boot:run</code></pre>

<h3>2. Testing with Swagger UI (Recommended)</h3>
<p>You do not need Postman to test this API! Once the application is running, follow these steps:</p>
<ol>
  <li>Open your browser and navigate to: <a href="http://localhost:8080/swagger-ui/index.html">http://localhost:8080/swagger-ui/index.html</a></li>
  <li><b>Register:</b> Expand the <code>POST /register</code> endpoint, click <b>Try it out</b>, enter a username and password in the Request body, and click <b>Execute</b>.</li>
  <li><b>Login:</b> Expand the <code>POST /login</code> endpoint, click <b>Try it out</b>, enter your registered credentials, and click <b>Execute</b>. Copy the JWT token string from the Response body.</li>
  <li><b>Authorize:</b> Scroll to the top of the Swagger page and click the green <b>Authorize 🔓</b> button. Paste your copied JWT token into the <code>Value</code> field and click <b>Authorize</b>.</li>
  <li><b>Test Protected Endpoints:</b> You can now test any of the <code>/products</code> endpoints. Swagger will automatically attach your JWT token to the request headers!</li>
</ol>
<h2>Future Enhancements</h2>
<ul>
  <li>Implement Role-Based Access Control (e.g., Admin vs Standard User).</li>
  <li>Dockerize the application and database using <code>docker-compose</code>.</li>
</ul>