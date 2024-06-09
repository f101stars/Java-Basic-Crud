import { useState } from "react";
import Adv4 from "./Adv4";
import User from "./User";

const MainComponent = () => {
    const [isAuthenticated, setAuthenticated] = useState(false);

    return (
        <>
            <User setAuthenticated={setAuthenticated} />
            <Adv4 isAuthenticated={isAuthenticated} />
        </>
    );
};

export default MainComponent;
