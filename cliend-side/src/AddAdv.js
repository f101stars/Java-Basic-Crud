import axios from "axios";
import { useState } from "react";
import Adv4 from "./Adv4";

const AddAdv = ({location, email}) => {

    const [img, setImg] = useState("");
    const [desiredEntrances, setDesiredEntrances] = useState("");
    const [cover, setCover] = useState(true);






    // פונקציה המטפלת בשינויים בטופס
    const handleChange = (event) => {

        const { name, value } = event.target;
        switch (name) {
            case "img":
                setImg(value);
                break;
            case "desiredEntrances":
                setDesiredEntrances(value);
                break;
            default:
                break;
        }
    };

    // פונקציה המטפלת בשליחת הטופס
    const submitForm = async (event) => {
        event.preventDefault();

        try {
            // שליחת בקשת POST לשרת
            await axios.post("http://localhost:3333/adv/entrance/add", {
                img,
                desiredEntrances,
                location: location,
                email: email,
                // user: 74
            });


            // איפוס יצירת המשתנים לתוך הטופס
            setImg("");
            setDesiredEntrances("");

setCover(false)
window.location.reload();

        } catch (error) {
            console.error(error);
        }
    };

    return <>
       {cover&&  <form onSubmit={submitForm} className={cover? "form":"aaa"}>


            <input
                type="text"
                placeholder="נא להכניס שם תמונה "
                required
                name="img"
                onChange={handleChange}
            />
            <input
                value={desiredEntrances}
                placeholder="מספר כניסות  "
                required
                name="desiredEntrances"
                onChange={handleChange}
            />
            {/* כפתור לשליחת הטופס */}
            <button type="submit">
                שלח
        </button>
        </form>
}
    </>

}
export default AddAdv
