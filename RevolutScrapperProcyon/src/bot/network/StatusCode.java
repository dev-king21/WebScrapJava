// 
// Decompiled by Procyon v0.5.36
// 

package bot.network;

public enum StatusCode
{
    HTTP_OK(200), 
    HTTP_CREATED(201), 
    HTTP_ACCEPTED(202), 
    HTTP_NOT_AUTHORITATIVE(203), 
    HTTP_NO_CONTENT(204), 
    HTTP_RESET(205), 
    HTTP_PARTIAL(206), 
    HTTP_MULT_CHOICE(300), 
    HTTP_MOVED_PERM(301), 
    HTTP_MOVED_TEMP(302), 
    HTTP_SEE_OTHER(303), 
    HTTP_NOT_MODIFIED(304), 
    HTTP_USE_PROXY(305), 
    HTTP_BAD_REQUEST(400), 
    HTTP_UNAUTHORIZED(401), 
    HTTP_PAYMENT_REQUIRED(402), 
    HTTP_FORBIDDEN(403), 
    HTTP_NOT_FOUND(404), 
    HTTP_BAD_METHOD(405), 
    HTTP_NOT_ACCEPTABLE(406), 
    HTTP_PROXY_AUTH(407), 
    HTTP_CLIENT_TIMEOUT(408), 
    HTTP_CONFLICT(409), 
    HTTP_GONE(410), 
    HTTP_LENGTH_REQUIRED(411), 
    HTTP_PRECON_FAILED(412), 
    HTTP_ENTITY_TOO_LARGE(413), 
    HTTP_REQ_TOO_LONG(414), 
    HTTP_UNSUPPORTED_TYPE(415), 
    HTTP_UNPROCESSABLE_ENTITY(422), 
    @Deprecated
    HTTP_SERVER_ERROR(500), 
    HTTP_INTERNAL_ERROR(500), 
    HTTP_NOT_IMPLEMENTED(501), 
    HTTP_BAD_GATEWAY(502), 
    HTTP_UNAVAILABLE(503), 
    HTTP_GATEWAY_TIMEOUT(504), 
    HTTP_VERSION(505), 
    NOT_EXIST(1000);
    
    int value;
    
    private StatusCode(final int value) {
        this.value = value;
    }
    
    public static StatusCode parseCode(final int code) {
        switch (code) {
            case 200: {
                return StatusCode.HTTP_OK;
            }
            case 201: {
                return StatusCode.HTTP_CREATED;
            }
            case 202: {
                return StatusCode.HTTP_ACCEPTED;
            }
            case 203: {
                return StatusCode.HTTP_NOT_AUTHORITATIVE;
            }
            case 204: {
                return StatusCode.HTTP_NO_CONTENT;
            }
            case 205: {
                return StatusCode.HTTP_RESET;
            }
            case 206: {
                return StatusCode.HTTP_PARTIAL;
            }
            case 207: {
                return StatusCode.HTTP_NOT_AUTHORITATIVE;
            }
            case 300: {
                return StatusCode.HTTP_MULT_CHOICE;
            }
            case 301: {
                return StatusCode.HTTP_MOVED_PERM;
            }
            case 302: {
                return StatusCode.HTTP_MOVED_TEMP;
            }
            case 303: {
                return StatusCode.HTTP_SEE_OTHER;
            }
            case 304: {
                return StatusCode.HTTP_NOT_MODIFIED;
            }
            case 305: {
                return StatusCode.HTTP_USE_PROXY;
            }
            case 400: {
                return StatusCode.HTTP_BAD_REQUEST;
            }
            case 401: {
                return StatusCode.HTTP_UNAUTHORIZED;
            }
            case 402: {
                return StatusCode.HTTP_PAYMENT_REQUIRED;
            }
            case 403: {
                return StatusCode.HTTP_FORBIDDEN;
            }
            case 404: {
                return StatusCode.HTTP_NOT_FOUND;
            }
            case 405: {
                return StatusCode.HTTP_BAD_METHOD;
            }
            case 406: {
                return StatusCode.HTTP_NOT_ACCEPTABLE;
            }
            case 407: {
                return StatusCode.HTTP_PROXY_AUTH;
            }
            case 408: {
                return StatusCode.HTTP_CLIENT_TIMEOUT;
            }
            case 409: {
                return StatusCode.HTTP_CONFLICT;
            }
            case 410: {
                return StatusCode.HTTP_GONE;
            }
            case 411: {
                return StatusCode.HTTP_LENGTH_REQUIRED;
            }
            case 412: {
                return StatusCode.HTTP_PRECON_FAILED;
            }
            case 413: {
                return StatusCode.HTTP_ENTITY_TOO_LARGE;
            }
            case 414: {
                return StatusCode.HTTP_REQ_TOO_LONG;
            }
            case 415: {
                return StatusCode.HTTP_UNSUPPORTED_TYPE;
            }
            case 422: {
                return StatusCode.HTTP_UNPROCESSABLE_ENTITY;
            }
            case 500: {
                return StatusCode.HTTP_INTERNAL_ERROR;
            }
            case 501: {
                return StatusCode.HTTP_NOT_IMPLEMENTED;
            }
            case 502: {
                return StatusCode.HTTP_BAD_GATEWAY;
            }
            case 503: {
                return StatusCode.HTTP_UNAVAILABLE;
            }
            case 504: {
                return StatusCode.HTTP_GATEWAY_TIMEOUT;
            }
            case 505: {
                return StatusCode.HTTP_VERSION;
            }
            default: {
                return StatusCode.NOT_EXIST;
            }
        }
    }
}
