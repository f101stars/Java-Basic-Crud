import axios from "axios";
import { useEffect, useState } from "react"
import AddAdv from "./AddAdv"
import User from "./User";



const Adv4 = () => {
    const [input1, setInput1] = useState(false)
    const [input2, setInput2] = useState(false)
    const [input3, setInput3] = useState(false)
    const [input4, setInput4] = useState(false)

    const [imgs, setImgs] = useState([]);


    const fetchData = async () => {
      const { data } = await axios.get("http://localhost:3333/adv/entrance");
      setImgs(data);
      console.log(data);
  };
  useEffect(() => {
    fetchData();
  }, []);
  const img1=imgs.find((i)=>i.location===1)
  const img2=imgs.find((i)=>i.location===2)
  const img3=imgs.find((i)=>i.location===3)
  const img4=imgs.find((i)=>i.location===4)

    return <>
        {input1 &&  <User location={1} />}
        {input2 && <User location={2} />}
        {input3 && <User location={3} />}
        {input4 && <User location={4} />}
        <div className="adv4">
            <div className="one">
              {img1? <img url={img1.img} className="img"/>  :
                <button onClick={() => setInput1(!input1)} className="btu"> פרסם כאן</button>}
            </div>
            <div className="one">
            {img2?<img src={img2.img} className="img"/>  :

                <button onClick={() => setInput2(!input2)} className="btu"> פרסם כאן</button>}
            </div>
            <div className="one">
            {img3? <img src={img3.img+".jpg"} className="img"/>  :

                <button onClick={() => setInput3(!input3)} className="btu"> פרסם כאן</button>}
            </div>
            <div className="one">
            {img4?<img src={img4.img+".jpg"} className="img"/> :

                <button onClick={() => setInput4(!input4)} className="btu"> פרסם כאן</button>}
            </div>
        </div>
    </>


}


export default Adv4

