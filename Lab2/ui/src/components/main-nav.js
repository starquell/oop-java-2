import {NavLink} from "react-router-dom";
import React from "react";
import styles from "../styles/Navbar.module.css"

const MainNav = () => (
  <div className={styles.logo}>
    <NavLink
      to="/"
      exact
      className={styles.logoLink}
      activeClassName="router-link-exact-active"
    >
      Development Team
    </NavLink>

  </div>
);

export default MainNav;
