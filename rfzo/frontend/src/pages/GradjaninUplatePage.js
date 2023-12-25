import StandardLayout from "../layouts/StandardLayout";
import GradjaninUplate from "../components/GradjaninUplate/GradjaninUplate";

const GradjaninUplatePage = () => {
  return (
    <StandardLayout title="Vakcinacije za gradjane" fluid>
      <GradjaninUplate />
    </StandardLayout>
  );
};

export default GradjaninUplatePage;
