
#import "RNLockState.h"

NSString *const RCTLockCompleteNotification = @"com.apple.springboard.lockcomplete";
NSString *const RCTLockStateNotification = @"com.apple.springboard.lockstate";

@implementation RNLockState

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

- (NSArray<NSString *> *)supportedEvents
{
    return @[@"lockStateDidChange", @"lockComplete"];
}

- (void)startObserving
{
    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(handleLockStateChange:)
                                                 name:RCTLockCompleteNotification
                                               object:nil];

    [[NSNotificationCenter defaultCenter] addObserver:self
                                             selector:@selector(handleLockComplete:)
                                                 name:RCTLockCompleteNotification
                                               object:nil];
}

- (void)stopObserving
{
    [[NSNotificationCenter defaultCenter] removeObserver:self];
}

- (void)handleLockStateChange:(NSNotification *)notification
{
    NSString *newState;
    
    if ([notification.name isEqualToString:RCTLockStateNotification]) {
        [self sendEventWithName:@"lockStateDidChange" body:@{@"lockState"}]
    }
}

- (void)handleLockComplete:(NSNotification *)notification
{
    NSString *newState;
    newState = (NSString *)notification.name;
    
    [self sendEventWithName:@"lockComplete"
                       body:@{@"lockComplete"}]
}

@end
  
