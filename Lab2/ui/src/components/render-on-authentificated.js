import UserService from "../services/UserService";

const RenderOnAuthenticated = (component) => (UserService.isAdmin()) ? component : null;

export default RenderOnAuthenticated