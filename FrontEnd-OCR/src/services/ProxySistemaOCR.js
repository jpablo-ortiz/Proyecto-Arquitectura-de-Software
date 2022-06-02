import axios from "axios";

const IPJavaEE = "10.43.100.185";
const Port = "8080";

const baseUrl = "http://" + IPJavaEE + ":" + Port + "/BackEnd-OCR/ocr/";

const ListarCarros = () => {
    return axios
        .create({
            baseURL: baseUrl + "carros",
            headers: {
                "Content-Type": "application/json"
            }
        })
        .get("/listar"); // TODO arreglar
};

const SistemaOCR = {
    ListarCarros
};

export default SistemaOCR;