import { BrowserRouter, Redirect, Route, Switch } from "react-router-dom";
import Page from "./components/Page";
import Auth from "./components/Auth/Auth";
import WelcomePage from "./pages/WelcomePage";
import UplatePage from "./pages/UplatePage";
import OsiguraniciPage from "./pages/OsiguraniciPage";
import IzlistajFirmePage from "./pages/IzlistajFirmePage";
import IzlistajFirmeFormPage from "./pages/IzlistajFirmeFormPage";
import OsiguraniciFormPage from "./pages/OsiguraniciFormPage";
import UplateFormPage from "./pages/UplateFormPage";
import GradjaninUplatePage from "./pages/GradjaninUplatePage";

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/dobro-dosli" component={WelcomePage} />

        <Route path="/istorijaUplata/form" component={UplateFormPage} />
        <Route path="/istorijaUplata" component={UplatePage} />
        <Route path="/osiguranici/form" component={OsiguraniciFormPage} />
        <Route path="/osiguranici" component={OsiguraniciPage} />
        <Route path="/izlistajFirme/form" component={IzlistajFirmeFormPage} />
        <Route path="/izlistajFirme" component={IzlistajFirmePage} />
        <Route path="/gradjani" component={GradjaninUplatePage} />

        <Route path="/page" component={Page} />
        <Route path="/auth" component={Auth} />
        <Redirect to="/dobro-dosli" />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
