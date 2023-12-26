import authService from "./auth-service";

class NavbarService {
  zdravstveniRadnikLinks = [
    { url: "/vakcine", text: "Vakcine" },
    { url: "/vakcinacije", text: "Vakcinacije" },
    { url: "/osiguranici", text: "Osiguranici" },
    { url: "/transplatacije", text: "Transplantacije" },
  ];

  gradjaniLinks = [{ url: "/gradjani", text: "Vakcinacije za gradjane" }];

  getAllowedNavbarLinks = () => {
    const role = authService.getRoleFromJwt();
    if (role === "ZDRAVSTVENI_RADNIK") return this.zdravstveniRadnikLinks;
    else if (role === "GRADJANIN") return this.gradjaniLinks;
    return [];
  };
}

export default new NavbarService();
