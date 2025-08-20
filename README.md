<h1>Project Overview</h1>
<p>
  This project demonstrates an authorization logic implementation with Spring Security.
  The application models a scenario with two main user types:
</p>
<ul>
  <li>Vendors can add products to the system.</li>
  <li>Purchasers can view all vendor products and buy from them.</li>
  <li>Each purchase is recorded, and purchasers can view their own purchases.</li>
</ul>
<p>
  An admin role is also included for system-level management. 
  Access is controlled using Spring Security roles, ensuring that each user type only has access 
  to their own pages and resources.
</p>
<h2>Features</h2>
<ul>
  <li>
    <strong>User Registration & Login</strong>
    <ul>
      <li>
        Separate registration pages for vendors and purchasers
      </li>
      <li>
        Individual login pages for vendors, purchasers, and admin
      </li>
    </ul>
  </li>
  <li>
    <strong>Role-Based Access Control (Spring Security Roles)</strong>
    <ul>
      <li>
        Uses Spring Security roles (ROLE_VENDOR, ROLE_PURCHASER, ROLE_ADMIN) to restrict access
      </li>
      <li>
        Vendors, purchasers, and admins can only access pages assigned to their roles
      </li>
      <li>
        Vendors and purchasers can only manipulate their own resources, not those of other users.
        For example, a vendor can only delete his products not other vendors' products
      </li>
    </ul>
  </li>
  <li>
    <strong>Custom Security Configuration</strong>
    <ul>
      <li>
        Three UserDetailsService implementations for vendors, purchasers, and admins
      </li>
      <li>
        Three independent security filter chains to handle different login flows
      </li>
    </ul>
  </li>
</ul>
