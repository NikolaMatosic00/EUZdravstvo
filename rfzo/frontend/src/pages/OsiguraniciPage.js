import StandardLayout from "../layouts/StandardLayout";
import Osiguranici from "../components/Osiguranici/Osiguranici";

const OsiguraniciPage = () => {
  console.log("osiguranici");
  return (
    <StandardLayout title="Osiguranici" fluid>
      <Osiguranici />
    </StandardLayout>
  );
};

export default OsiguraniciPage;
