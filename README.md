<h1 align="center">Secure Product Management System</h1>

<p align="center">
  A RESTful API project built with <b>Spring Boot 3</b>. This application goes beyond basic CRUD by implementing <b>Spring Security</b> for authentication, <b>MySQL</b> for persistent data storage, and establishes a relational mapping between Users and Products.
</p>

<hr>

<h2>Tech Stack</h2>
<ul>
  <li><b>Java 21</b></li>
  <li><b>Spring Boot 3</b> (Web, Data JPA, Security)</li>
  <li><b>Spring Security</b> (Authentication & Authorization)</li>
  <li><b>MySQL</b> (Production-ready Database) / <b>H2</b> (In-memory testing)</li>
  <li><b>Postman (API testing)</b></li>
  <li><b>Spring Data JPA</b> (ORM & Repository Pattern)</li>
  <li><b>Lombok</b> (Boilerplate reduction)</li>
  <li><b>Maven</b> (Dependency Management)</li>
</ul>

<h2>Key Features</h2>
<ul>
  <li><b>User Management:</b> User registration and password storage.</li>
  <li><b>Authentication:</b> Secure login via Basic Auth or Form Login.</li>
  <li><b>Product Management:</b> Full CRUD operations for products.</li>
  <li><b>Data Relationship:</b> One-to-Many relationship (Users own Products). When a product is added, it is automatically linked to the logged-in user.</li>
  <li><b>Security:</b> CSRF protection (configurable) and authenticated endpoints.</li>
  <li><b>Exception Handling:</b> Custom error handling for resource not found (404).</li>
</ul>

<h2>API Endpoints</h2>
<p><i>Note: Most endpoints require Basic Authentication or a valid Session.</i></p>

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
      <td><code>GET</code></td>
      <td><code>/csrf-token</code></td>
      <td>Get CSRF Token (for testing POST/PUT/DELETE)</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td><code>GET</code></td>
      <td><code>/products</code></td>
      <td>Retrieve all products</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td><code>GET</code></td>
      <td><code>/products/{id}</code></td>
      <td>Retrieve a specific product by ID</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td><code>POST</code></td>
      <td><code>/products</code></td>
      <td>Add a new product (Linked to current User)</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td><code>PUT</code></td>
      <td><code>/products</code></td>
      <td>Update an existing product</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td><code>DELETE</code></td>
      <td><code>/products/{id}</code></td>
      <td>Delete a specific product</td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>

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
<p>To switch back to H2, comment out the MySQL section in <code>application.properties</code> and uncomment the H2 section in <code>application-h2.properties</code>.</p>

<h2>How to Run</h2>

<h3>1. Clone the repository</h3>
<pre><code>git clone https://github.com/tzuhuanl/Product-Management-System.git</code></pre>

<h3>2. Run the application</h3>
<pre><code>mvn spring-boot:run</code></pre>

<h3>3. Testing with Postman</h3>
<ul>
  <li><b>Register:</b> Send a POST to <code>/register</code> with JSON body <code>{"username": "test", "password": "123"}</code>.</li>
  <li><b>Login/Access:</b> In Postman, go to the <b>Authorization</b> tab, select <b>Basic Auth</b>, and enter your registered username and password.</li>
</ul>

<h2>Future Enhancements</h2>
<ul>
  <li>Implement <b>JWT (JSON Web Token)</b> for stateless authentication.</li>
  <li>Add role-based authorization (Admin vs User).</li>
  <li>Integrate Swagger (SpringDoc) for interactive API documentation.</li>
</ul>