import authService from "./auth-service";

class NavbarService {
  administrativniRadnikLinks = [
    { url: "/izlistajFirme", text: "Firme" },
    { url: "/istorijaUplata", text: "Uplate" },
    { url: "/osiguranici", text: "Osiguranici" },
  ];

  osiguranikLinks = [{ url: "/gradjani", text: "Istorija uplata" }];

  getAllowedNavbarLinks = () => {
    const role = authService.getRoleFromJwt();
    if (role === "ADMINISTRATIVNI_RADNIK")
      return this.administrativniRadnikLinks;
    else if (role === "GRADJANIN") return this.osiguranikLinks;

    return [];
  };
}

export default new NavbarService();
