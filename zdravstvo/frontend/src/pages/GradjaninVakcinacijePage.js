import StandardLayout from "../layouts/StandardLayout";
import GradjaninVakcinacije from "../components/GradjaninVakcinacije/GradjaninVakcinacije";

const GradjaninVakcinacijePage = () => {
  return (
    <StandardLayout title="Vakcinacije za gradjane" fluid>
      <GradjaninVakcinacije />
    </StandardLayout>
  );
};

export default GradjaninVakcinacijePage;
