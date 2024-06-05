import { ProductDetail } from "./ProductDetail"

export const ProductGrid = ({handlerProductSelected, handlerRemove, products}) => {

    return (
        <table className="table table-hover table-striped">
            <thead>
                <tr>
                    <th>name</th>
                    <th>description</th>
                    <th>price</th>
                    <th>update</th>
                    <th>remove</th>
                </tr>
            </thead>
            <tbody>
                {products.map(product => {
                    return<ProductDetail handlerProductSelected = {handlerProductSelected} handlerRemove = {handlerRemove} product={product} key={product.name}/>
                })}
            </tbody>
        </table>
    )
}