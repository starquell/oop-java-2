import React from "react";

import App from "./App.js"
import * as ReactDOM from "react-dom";
import { BrowserRouter as Router } from "react-router-dom";
import Auth0ProviderWithHistory from "./auth/auth0-provider-with-history";
import UserService from "./services/UserService";

const renderApp = () =>
ReactDOM.render(
    <Router>
        <Auth0ProviderWithHistory>
            <App />
        </Auth0ProviderWithHistory>
    </Router>,
    document.getElementById("root"))

UserService.initKeycloak(renderApp);