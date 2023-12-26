import { BrowserRouter, Redirect, Route, Switch } from "react-router-dom";
import Page from "./components/Page";
import Auth from "./components/Auth/Auth";
import WelcomePage from "./pages/WelcomePage";
import VakcinacijePage from "./pages/VakcinacijePage";
import OsiguraniciPage from "./pages/OsiguraniciPage";
import TransplatacijePage from "./pages/TransplatacijePage";
import VakcinePage from "./pages/VakcinePage";
import VakcineFormPage from "./pages/VakcineFormPage";
import OsiguraniciFormPage from "./pages/OsiguraniciFormPage";
import TransplatacijeFormPage from "./pages/TransplatacijeFormPage";
import VakcinacijeFormPage from "./pages/VakcinacijeFormPage";
import GradjaninVakcinacijePage from "./pages/GradjaninVakcinacijePage";

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/dobro-dosli" component={WelcomePage} />

        <Route path="/vakcinacije/form" component={VakcinacijeFormPage} />
        <Route path="/vakcinacije" component={VakcinacijePage} />
        <Route path="/osiguranici/form" component={OsiguraniciFormPage} />
        <Route path="/osiguranici" component={OsiguraniciPage} />
        <Route path="/transplatacije/form" component={TransplatacijeFormPage} />
        <Route path="/transplatacije" component={TransplatacijePage} />
        <Route path="/vakcine/form" component={VakcineFormPage} />
        <Route path="/vakcine" component={VakcinePage} />
        <Route path="/gradjani" component={GradjaninVakcinacijePage} />

        <Route path="/page" component={Page} />
        <Route path="/auth" component={Auth} />
        <Redirect to="/dobro-dosli" />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
