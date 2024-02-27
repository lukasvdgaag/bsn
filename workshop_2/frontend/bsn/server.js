const fastify = require('fastify')({logger: true});
const path = require('path');
const fastifyStatic = require('@fastify/static');
const fastifyCors = require('@fastify/cors');

// Register the fastify-static plugin
fastify.register(fastifyStatic, {
    root: path.join(__dirname, 'public'),
});

fastify.register(fastifyCors, {
  origin: "*" // This will allow all origins
});


// Start the server
fastify.listen({port: 3000, host: '0.0.0.0'}, (error, address) => {
    if (error) {
        fastify.log.error(error);
        process.exit(1);
    }
})