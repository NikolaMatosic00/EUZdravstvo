import StandardLayout from "../layouts/StandardLayout";
import Vakcinacije from "../components/Vakcinacije/Vakcinacije";

const VakcinacijePage = () => {
  return (
    <StandardLayout title="Vakcinacije" fluid>
      <Vakcinacije />
    </StandardLayout>
  );
};

export default VakcinacijePage;
