const redis = require('redis');
const client = redis.createClient({
    socket: {
        host: 'redis_service',
        port: '6379'
    }
});

client.on('error', err => {
    console.log('Error ' + err);
});
