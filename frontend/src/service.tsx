import axios from "axios";
import { DummProducts } from "./models/DummProducts";

const config = axios.create({
    baseURL: 'https://dummyjson.com/',
    timeout: 15000
})

export const login = (username: string, password: string) => {
    const sendObj = {
        username: username,
        password: password
    }
    return config.post('auth/login', sendObj)
}

export const allProduct = () => {
    return config.get<DummProducts>('products')
}