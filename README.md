<h1 align="center">Secure Product Management System</h1>

<p align="center">
  A RESTful API project built with <b>Spring Boot 3</b>. This application goes beyond basic CRUD by implementing <b>Spring Security with JWT (JSON Web Tokens)</b> for stateless authentication, <b>MySQL</b> for persistent data storage, and establishes a relational mapping between Users and Products.
</p>

<hr>

<h2>Tech Stack</h2>
<ul>
  <li><b>Java 21</b></li>
  <li><b>Spring Boot 3</b> (Web, Data JPA, Security)</li>
  <li><b>Spring Security & JWT (io.jsonwebtoken)</b> (Stateless Authentication & Authorization)</li>
  <li><b>MySQL</b> (Production-ready Database) / <b>H2</b> (In-memory testing)</li>
  <li><b>Postman</b> (API testing)</li>
  <li><b>Spring Data JPA</b> (ORM & Repository Pattern)</li>
  <li><b>Lombok</b> (Boilerplate reduction)</li>
  <li><b>Maven</b> (Dependency Management)</li>
</ul>

<h2>Key Features</h2>
<ul>
  <li><b>User Management:</b> User registration and secure password storage using <b>Bcrypt Password Encoder</b>.</li>
  <li><b>Stateless Authentication (JWT):</b> Secure login mechanism that generates and validates JSON Web Tokens.</li>
  <li><b>Product Management:</b> Full CRUD operations for products.</li>
  <li><b>Data Relationship:</b> One-to-Many relationship (Users own Products). When a product is added, it is automatically linked to the authenticated user.</li>
  <li><b>Security:</b> Custom <code>JwtFilter</code> to intercept requests and validate bearer tokens. CSRF is disabled as the application relies on stateless JWT authentication.</li>
  <li><b>Exception Handling:</b> Custom error handling for resource not found (404).</li>
</ul>

<h2>API Endpoints</h2>

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
<p><i>Note: The <code>/csrf-token</code> endpoint exists for legacy testing, but CSRF is disabled in the security configuration.</i></p>

<h2>Database Configuration</h2>

<p>This project is configured to use <b>MySQL</b> by default. You need to update <code>src/main/resources/application.properties</code> with your database credentials.</p>

<h3>1. MySQL Setup</h3>
<p>Create a database named <code>userdetails</code> (or update the URL in properties):</p>
<pre><code>CREATE DATABASE userdetails;</code></pre>

<p>Update <code>application.properties</code>:</p>
<pre><code>spring.datasource.url=jdbc:mysql://localhost:3306/userdetails
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update</code></pre>

<h3>2. (Optional) H2 Database</h3>
<p>To switch back to H2, comment out the MySQL section in <code>application.properties</code> and uncomment the H2 section.</p>

<h2>How to Run</h2>

<h3>1. Clone the repository</h3>
<pre><code>git clone https://github.com/tzuhuanl/Product-Management-System.git</code></pre>

<h3>2. Run the application</h3>
<pre><code>mvn spring-boot:run</code></pre>

<h3>3. Testing with Postman (JWT Flow)</h3>
<ul>
  <li><b>1. Register:</b> Send a <code>POST</code> request to <code>/register</code> with JSON body:
    <pre><code>{
  "username": "testuser",
  "password": "password123"
}</code></pre>
  </li>
  <li><b>2. Login (Get Token):</b> Send a <code>POST</code> request to <code>/login</code> with the same JSON body. The response will be your JWT string.</li>
  <li><b>3. Access Protected Endpoints:</b> To access routes like <code>GET /products</code> or <code>POST /products</code>, go to the <b>Authorization</b> tab in Postman, select <b>Bearer Token</b>, and paste the JWT string you received from the login step.</li>
</ul>

<h2>Future Enhancements</h2>
<ul>
  <li>Implement Role-Based Access Control (e.g., Admin vs Standard User).</li>
  <li>Add refresh tokens for extended sessions without requiring re-login.</li>
  <li>Dockerize the application and database using <code>docker-compose</code>.</li>
</ul>