// server.js
const jsonServer = require('json-server')
const server = jsonServer.create()
const router = jsonServer.router('db.json')

// In this example we simulate a server side error response
router.render = (req, res) => {
  res.status(420).jsonp({
    error: "error message here"
  })
}

server.use(router)
server.listen(3000, () => {
  console.log('JSON Server is running')
})
